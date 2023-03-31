package com.example.a

import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmployeeD {
    class EmployeeD : AppCompatActivity() {
        var binding: ActivityEmployeeDBinding? = null

        private var nameet: EditText? = null
        private var emailet: EditText? = null

        var nameEntered: String? = null
        var emailEntered: String? = null

        private var genderSelected: String = ""
        //for storing the selected Gender

        private var yearSelected: String = ""

        private var btechet: EditText? = null

        private var dobtv: TextView? = null
        private var calendarImageView: ImageView? = null

        var dobSelected: String? = null

        private var datetimetv: TextView? = null
        private var dateandtimeImageView: Button? = null

        var dateTimeSelected: String? = null

    }
}