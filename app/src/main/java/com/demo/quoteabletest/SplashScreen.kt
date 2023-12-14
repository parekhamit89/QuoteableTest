package com.demo.quoteabletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout


class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var motionLayout: MotionLayout = findViewById(R.id.motionLayout)
        var imgView: ImageView = findViewById<ImageView>(R.id.ic_cloud)
        var textView: TextView = findViewById(R.id.anim_instruction)
        imgView.setOnClickListener {
            textView.setTextColor(getColor(R.color.blue))
        }

        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
            ) {
//                TODO("Not yet implemented")
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float,
            ) {
//                TODO("Not yet implemented")
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (motionLayout != null) {
                    if (motionLayout.currentState == R.id.end) {
                        moveToMainActivity(300)
                    }
                }
            }


            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float,
            ) {
//                TODO("Not yet implemented")
            }

        })

        moveToMainActivity(7000)
    }

    fun moveToMainActivity(delay: Long) {

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, delay)


    }
}