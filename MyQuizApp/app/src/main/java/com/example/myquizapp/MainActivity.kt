package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnstart = findViewById<Button>(R.id.btn_start)
        val etname = findViewById<TextView>(R.id.et_name)
        btnstart.setOnClickListener {
            if(etname.text.isEmpty())
            {
                Toast.makeText(this,"please enter your name",Toast.LENGTH_LONG).show()
            }
            else
            {
                val intent = Intent(this, MyQuizQuestions :: class.java)
                startActivity(intent)
            }
        }
    }
}