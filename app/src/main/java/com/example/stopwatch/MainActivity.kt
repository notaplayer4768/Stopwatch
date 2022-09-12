package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    //how to make classwide static constant in kotlin
    companion object {
        //all your "static" constants go here
        val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"onDestroy")
    }
}