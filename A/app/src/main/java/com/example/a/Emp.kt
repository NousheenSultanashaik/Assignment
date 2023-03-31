package com.example.a

import android.app.Application

class Emp  : Application(){

        val db by lazy {

            EmployeeDB.getInstance(this)

        }
    }
