package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    //how to make classwide static constant in kotlin
    companion object {
        //all your "static" constants go here
        val TAG = "MainActivity"
    }
    private lateinit var start : Button
    private lateinit var reset : Button
    private lateinit var timer : Chronometer
    var saysStart = true

    override fun onCreate(savedInstanceState: Bundle?) {
        //timer.stop()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wideWidgets()
        start.setOnClickListener{
            /*
            if(!saysStart)
            {
                saysStart = true
                start.setText("Start")
                timer.stop()
            }
             */
            if(saysStart)
            {
                saysStart = false
                start.setText("Stop")
                timer.start()
            }



        }
    }

    private fun wideWidgets() {
        start = findViewById(R.id.button_main_start)
        reset = findViewById(R.id.button_main_reset)
        timer = findViewById(R.id.chronometer_main_stopwatch)
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