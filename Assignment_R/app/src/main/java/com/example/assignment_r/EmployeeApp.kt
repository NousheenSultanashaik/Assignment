package com.example.assignment_r

import android.app.Application

class EmployeeApp: Application() {

    val db by lazy {
        EmployeeDatabase.getInstance(this)
    }

}