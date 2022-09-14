package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //how to make classwide static constant in kotlin
    companion object {
        //all your "static" constants go here
        val TAG = "MainActivity"
    }
    private lateinit var start : Button
    private lateinit var reset : Button
    private lateinit var timer : Chronometer
    private lateinit var debug : TextView
    private var base = 0L
    private var saysStart = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wideWidgets()

        start.setOnClickListener{
            debug.setText("${SystemClock.elapsedRealtime()} base $base")
            if(!saysStart)
            {
                saysStart = true
                start.setText("Start")
                timer.stop()
                base = SystemClock.elapsedRealtime()
            }
            else if(saysStart)
            {
                saysStart = false
                start.setText("Stop")
                timer.base = base
                timer.start()

            }
        }
    }

    private fun wideWidgets() {
        start = findViewById(R.id.button_main_start)
        reset = findViewById(R.id.button_main_reset)
        timer = findViewById(R.id.chronometer_main_stopwatch)
        debug = findViewById(R.id.textView_debug)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy: ")
    }
}