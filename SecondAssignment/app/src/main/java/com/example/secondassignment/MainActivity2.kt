package com.example.secondassignment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val plusImageView = findViewById<ImageView>(R.id.plusImageView)
        plusImageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        // create the list of MyData objects
        val myDataList = listOf(
            MyData("John", "john@example.com", "2022", "01/01/1990", "27 Mar, 2023 3:30 PM", "4.5", "my work"),
            MyData("Emily", "emily@example.com", "2021", "15/03/1995", "26 Mar, 2023 10:45 AM", "3.2", "my work"),
            MyData("Mike", "mike@example.com", "2020", "25/12/1992", "24 Mar, 2023 6:15 PM", "4.8", "my work"),
            MyData("Sarah", "sarah@example.com", "2019", "10/08/1994", "23 Mar, 2023 2:30 PM", "4.1", "my work"),
            MyData("Chris", "chris@example.com", "2018", "05/04/1991", "22 Mar, 2023 9:15 AM", "3.7", "my work")
        )

        // get the reference of RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        // set the layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyRecyclerViewAdapter(myDataList)
        recyclerView.adapter = adapter
    }
}
