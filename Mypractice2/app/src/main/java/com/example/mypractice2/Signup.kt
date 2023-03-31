package com.example.mypractice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val createdid : Button = findViewById(R.id.createid)
        createdid.setOnClickListener {
            Toast.makeText(this,"account created successfully ", Toast.LENGTH_SHORT).show()
        }

    }
}