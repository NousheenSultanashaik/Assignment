package com.example.practice

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter( private val userList: List<User>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val emailTextView: TextView = itemView.findViewById(R.id.tvEmail)
        val genderTextView: TextView = itemView.findViewById(R.id.tvGender)
        val dobTextView: TextView = itemView.findViewById(R.id.tvDOB)
        val btechPassoutYearTextView: TextView = itemView.findViewById(R.id.tvBtechPassoutYear)
        val howDoYouRateYourselfTextView: TextView = itemView.findViewById(R.id.rateYourselfTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user.name
        holder.emailTextView.text = user.email
        holder.genderTextView.text = user.gender
        holder.dobTextView.text=user.dob
        holder.btechPassoutYearTextView.text=user.btechPassoutYear
    }
    override fun getItemCount(): Int {
        return userList.size
    }

    }
