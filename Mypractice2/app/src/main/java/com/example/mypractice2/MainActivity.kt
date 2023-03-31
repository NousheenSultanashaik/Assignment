

package com.example.mypractice2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username: TextView = findViewById(R.id.loginid)
        val password: TextView = findViewById(R.id.passwordid)
        val loginbtn: Button = findViewById(R.id.loginbtn)
        loginbtn.setOnClickListener {
            if (username.text.toString() == "dudu" && password.text.toString() == "dudu") {
                Toast.makeText(this, "Login successfull", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
        val secondbtn: TextView = findViewById(R.id.secondbtn)
        secondbtn.setOnClickListener {
            functionclicked1()
        }
        val signupbtn: TextView = findViewById(R.id.signupbtn)
        signupbtn.setOnClickListener{
            functionclicked2()
        }
    }

    private fun functionclicked2() {
        val intent = Intent(this,Signup::class.java)
        startActivity(intent)
    }

    private fun functionclicked1() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }



}
