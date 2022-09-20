package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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
        val STATE_TIME = "display time"
        val IS_RUNNING = "if is running"

    }
    private lateinit var start : Button
    private lateinit var reset : Button
    private lateinit var timer : Chronometer
    private lateinit var debug : TextView
    private var base = 0L
    private var saysStart = true
    private var stopTime = 0L
    private var displayTime = 0L
    private var stopIndex = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wideWidgets()
        //restore instance state if it exists
        if(savedInstanceState!= null) {
            displayTime = savedInstanceState.getLong(STATE_TIME)
            timer.base = SystemClock.elapsedRealtime()-displayTime
            saysStart = savedInstanceState.getBoolean(IS_RUNNING)
            if(!saysStart)
                timer.start()
        }
        start.setOnClickListener{
            debug.setText("${SystemClock.elapsedRealtime()} base $base")
            if(!saysStart)
            {
                saysStart = true
                start.setText("Start")
                timer.stop()
                stopIndex = SystemClock.elapsedRealtime()
            }
            else if(saysStart)
            {
                saysStart = false
                start.setText("Stop")
                stopTime += SystemClock.elapsedRealtime() - stopIndex
                timer.base = SystemClock.elapsedRealtime() - stopTime
                timer.start()
            }
        }
        reset.setOnClickListener{
            //placeholder
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        //preserve state through orientation changes
        //save key value pairs to the bundle before the superclass call
        //calculate the display time
        if(!saysStart) {
            displayTime = SystemClock.elapsedRealtime() - timer.base
        }
        outState.putBoolean(IS_RUNNING,saysStart)

        outState.putLong(STATE_TIME,displayTime)
        super.onSaveInstanceState(outState)
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