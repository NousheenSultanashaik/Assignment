package com.example.secondassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


 class MyRecyclerViewAdapter(private val items: List<MyData>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.emailTextView.text = item.email
        holder.passoutYearTextView.text = item.passoutYear
        holder.dobTextView.text = item.dob
        holder.dateAndTimeTextView.text = item.dateAndTime
        holder.ratingTextView.text = item.rating
        holder.howDoYouRateTextView.text = "How do you rate ${item.ratingMe}?"
    }
     override fun getItemCount(): Int {
         return items.size
     }

     inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        val passoutYearTextView: TextView = itemView.findViewById(R.id.passoutYearTextView)
        val dobTextView: TextView = itemView.findViewById(R.id.dobTextView)
        val dateAndTimeTextView: TextView = itemView.findViewById(R.id.dateAndTimeTextView)
        val ratingTextView: TextView = itemView.findViewById(R.id.ratingTextView)
        val howDoYouRateTextView: TextView = itemView.findViewById(R.id.howDoYouRateTextView)
    }


}
