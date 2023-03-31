package com.example.dobcalc

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btndatepicker : Button = findViewById(R.id.btndatepicker)
        btndatepicker.setOnClickListener {
            clickDatePicker()
        }
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val tvselecteddate : TextView = findViewById(R.id.tvselecteddate)
        val tvselecteddateinminutes : TextView = findViewById(R.id.tvselecteddateinminutes)
        val dpd =     DatePickerDialog( this, { _ , selectedyear, selectedmonth, selecteddayOfMonth ->
            val selecteddate = "$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
            tvselecteddate.text = selecteddate
            val sdf = SimpleDateFormat("dd/MM/yy", Locale.ENGLISH)
            val theDate = sdf.parse(selecteddate)
            theDate?.let {
                val selecteddateinminutes = theDate.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentDate?.let {
                    val currentDateInMinutes = currentDate.time / 60000
                    val differenceInMinutes = currentDateInMinutes - selecteddateinminutes
                    tvselecteddateinminutes.text = differenceInMinutes.toString()
                }

                }
                                              },
            year, month,day)

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }
}