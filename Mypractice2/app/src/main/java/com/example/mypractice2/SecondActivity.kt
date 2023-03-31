package com.example.mypractice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val newpassword: TextView = findViewById(R.id.newpassword)
        val conformpassword: TextView = findViewById(R.id.conformpassword)
        val finished: Button = findViewById(R.id.finished)
        finished.setOnClickListener {
            if (newpassword.text.toString() == "DUDU" && conformpassword.text.toString() == "DUDU") {
                Toast.makeText(this,"successfully ",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"failed to set password",Toast.LENGTH_SHORT).show()
            }
        }
    }
}