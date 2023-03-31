package com.example.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddUserActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        nameEditText = findViewById(R.id.name_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        val savebutton = findViewById<Button>(R.id.save_button)
        savebutton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            if(name.isEmpty() || email.isEmpty()){
                Toast.makeText(this,"Please enter the details",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent()
                intent.putExtra(MainActivity.EXTRA_NAME, name)
                intent.putExtra(MainActivity.EXTRA_EMAIL, email)
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}