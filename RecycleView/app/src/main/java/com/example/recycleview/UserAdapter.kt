package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class User(val name: String, val email : String)
class UserAdapter(private val userList: MutableList<User>):
        RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_edit_text)
        val emailTextView: TextView = itemView.findViewById(R.id.email_edit_text)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user?.name
        holder.emailTextView.text=user?.email
    }

    override fun getItemCount() = userList.size
        fun addUser(user: User){
            userList.add(user)
            notifyItemInserted(userList.size-1)
    }
}
