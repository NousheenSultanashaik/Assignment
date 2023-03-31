package com.example.mypractice1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val diceroler: Button = findViewById(R.id.button1)

        diceroler.setOnClickListener {
            functionclicked()
        }
    }
        fun functionclicked(){
            val textview1 : TextView = findViewById(R.id.textview1)
            textview1.text = " hi dudu i will kill you"




        }

    }


    //


