package com.example.a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var recyclerView: RecyclerView? = null
    private var nxtBtn: ImageButton? = null
    private var Edit: TextView? = null
    private var employeedao: EmployeDAO? = null
    private var usersList: ArrayList<EmployeEntity>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        recyclerView = binding?.recyclerview
        nxtBtn = binding?.plusImg
        nxtBtn?.setOnClickListener {
            val intent = Intent(this, EmployeeD::class.java)
            startActivity(intent)
            //adding the new user....
            employeedao = (application as Emp).db.employeedao()
            lifecycleScope.launch {
                employeedao?.fetchAllUsers()?.collect {

                    usersList = ArrayList(it)
                    //fetching all users into arrayList

                    listToRv(usersList!!, employeedao!!)

                }
            }
            Edit = binding?.edit
            Edit?.setOnClickListener {

                val Adapter =
                    Adapter(usersList!!)


            }


        }
        fun nextActivityOnClickingCard(
            usersList: ArrayList<EmployeEntity>,
            rvItemAdapter: Adapter
        ) {

            recyclerView?.layoutManager = LinearLayoutManager(this)
            recyclerView?.adapter = Adapter

            rvItemAdapter.onItemClick = {
                //It is the RvItemAdapter's  lambda method

                val intent = Intent(this, EmployeeD::class.java)
                intent.putExtra("EmployeeEntity", it)
                //carry forward the user's data into edit page we use parcelable....

                startActivity(intent)

            }

        }


    }

    private fun listToRv(
        usersList: ArrayList<EmployeEntity>,         //converting arrayList to Item in RecyclerView
        EmployeDao: EmployeDAO
    ) {
        if (usersList.isNotEmpty()) {
            //checking whether the is null !!

            val rvAdapter = Adapter(usersList)
            binding?.recyclerview?.layoutManager = LinearLayoutManager(this)
            //Setting the layout manager to item in recycler view

            binding?.recyclerview?.adapter = Adapter
            // Assigning the created adapter to recycler view's adapter

            Adapter.onDeleteClick = {
                deleteUser(it)
                //deleting the user after clicking the cancel image
            }

            nextActivityOnClickingCard(usersList, Adapter)
            //On clicking the card the details of user should filled in user page
        }

    }

    private fun nextActivityOnClickingCard(usersList: java.util.ArrayList<EmployeEntity>, adapter: Adapter) {
        recyclerView?.layoutManager = LinearLayoutManager(this)
            recyclerView?.adapter = Adapter

            Adapter.onItemClick = {
                //It is the RvItemAdapter's  lambda method

                val intent = Intent(this, EmployeeD::class.java)
                intent.putExtra("EmployeeEntity", it)
                //carry forward the user's data into edit page we use parcelable....

                startActivity(intent)

            }

        TODO("Not yet implemented")
    }
    private fun deleteUser(EmployeEntity: EmployeEntity) {
        lifecycleScope.launch {
            employeedao?.delete(EmployeEntity)
            //deleting the User
        }
        Toast.makeText(this, "Deleted ${EmployeEntity.name}", Toast.LENGTH_SHORT).show()

    }
    override fun onDestroy() {
        super.onDestroy()
        //assigning the binding to null
        binding = null
    }

}


