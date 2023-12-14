package com.demo.quoteabletest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.demo.quoteabletest.databinding.QuoteItemViewBinding
import com.demo.quoteabletest.model.Result

class QuotesAdapter : ListAdapter<Result,QuotesAdapter.QuoteViewHolder>(QuoteDiffUtil()) {
    inner class QuoteViewHolder( val binding: QuoteItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {

        val binding = QuoteItemViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(binding)

    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.binding.tvQuote.text = "\"${getItem(position).content}\""
        holder.binding.tvAuthor.text = "- ${getItem(position).author}"
    }

    class QuoteDiffUtil: ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
           return oldItem._id ==newItem._id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.content ==newItem.content
        }

    }
}