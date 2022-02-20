package com.bhaveshsp.classyplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ImageView>(R.id.hatImage).
        startAnimation(AnimationUtils.loadAnimation(this,R.anim.bounce_animation))
        Thread{
            try {
                Thread.sleep(3000)
                startActivity(Intent(this,HomeActivity::class.java))
            }catch (e : IOException){
                Log.d(TAG, "onCreate: $e")
            }
        }.start()
    }
    companion object{
        private const val TAG = "MainActivity"
    }
}