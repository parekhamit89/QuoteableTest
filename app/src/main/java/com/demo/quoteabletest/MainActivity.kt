package com.demo.quoteabletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.quoteabletest.databinding.ActivityMainBinding
import com.demo.quoteabletest.viewModels.MainViewModel
import com.demo.quoteabletest.viewModels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    private lateinit var adapater: QuotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        val repository = (application as QuotableApp).quotableRepository

        activityMainBinding.quoteRecyclerView.layoutManager = LinearLayoutManager(this)
        activityMainBinding.progressBar.visibility= View.VISIBLE
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Toast.makeText(this@MainActivity, it.results.size.toString(), Toast.LENGTH_SHORT).show()

            if (this::adapater.isInitialized) {
                adapater.submitList(it.results)
            } else {
                adapater = QuotesAdapter()
                activityMainBinding.quoteRecyclerView.adapter = adapater
                adapater.submitList(it.results)
            }

            activityMainBinding.progressBar.visibility= View.INVISIBLE
        })
    }


}