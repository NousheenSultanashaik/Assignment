package com.example.practice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var cardView: CardView
    private lateinit var minusImage: ImageView
    private lateinit var editText: TextView
    private var isEditMode = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cardView = findViewById(R.id.card_view)
        minusImage = findViewById(R.id.minus)
        editText = findViewById(R.id.edit_text)
        editText.setOnClickListener {
            isEditMode = !isEditMode
            minusImage.visibility = if (isEditMode) View.VISIBLE else View.GONE
            val constraintSet = ConstraintSet()
            constraintSet.clone(constraintSet)
            constraintSet.clear(R.id.card_view, ConstraintSet.START)
            constraintSet.connect(
                R.id.card_view,
                ConstraintSet.START,
                if (isEditMode) R.id.minus else R.id.edit_text,
                ConstraintSet.END,

            )
            constraintSet.applyTo(findViewById(R.id.constraint_layout))
        }
        val userList = mutableListOf<User>()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(userList)
        recyclerView.adapter = adapter

        val plusImageView = findViewById<ImageView>(R.id.plusImageView)
        plusImageView.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent, 1)
        }


        }
    }
