package com.example.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerview: RecyclerView = findViewById(R.id.recycler_view)
        val plusimage: ImageView = findViewById(R.id.plus_image)
        setContentView(R.layout.activity_main)
        val userList = mutableListOf<User>()
        val adapter = UserAdapter(userList)
        recyclerview.adapter = adapter
        plusimage.setOnClickListener {
            val intent = Intent(this, AddUserActivity::class.java)
            startActivityForResult(intent, ADD_USER_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ADD_USER_REQUEST && resultCode == RESULT_OK){
            val name = data?.getStringExtra(EXTRA_NAME)?: ""
            val email = data?.getStringExtra(EXTRA_EMAIL)?: ""
            val user = User(name,email)
            userAdapter?.addUser(user)
        }
    }
    companion object{
        const val ADD_USER_REQUEST =1
        const val EXTRA_NAME ="com.recyclerview.NAME"
        const val EXTRA_EMAIL ="com.recyclerview.EMAIL"

    }
}