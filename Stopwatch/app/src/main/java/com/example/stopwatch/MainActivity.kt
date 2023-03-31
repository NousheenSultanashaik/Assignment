package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnstart : Button = findViewById(R.id.btnstart)
        val btnpause : Button = findViewById(R.id.btnpause)
        val btnreset : Button = findViewById(R.id.btnreset)
        val chronometer : Chronometer = findViewById(R.id.chronometer)
        var pauseAt : Long = 0
        btnstart.setOnClickListener()
        {
            chronometer.base = SystemClock.elapsedRealtime()-pauseAt //6000
            chronometer.start()
        }
        btnpause.setOnClickListener()
        {
            pauseAt = SystemClock.elapsedRealtime()-chronometer.base /* 10000-6000 */
            chronometer.stop()

        }
        btnreset.setOnClickListener()
        {
            chronometer.base = SystemClock.elapsedRealtime()
        }

    }
}