package com.example.assignment

import android.app.DatePickerDialog
import android.content.res.ColorStateList
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.assignment.R.array.years
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var menButton: Button
    private lateinit var womenButton: Button
    private lateinit var vectorImageView: ImageView
    private lateinit var dobTextView: TextView
    private lateinit var calendarImageView: ImageView
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val submitButton = findViewById<Button>(R.id.submitbtn)

        submitButton.setOnClickListener {
            val nameEditText = findViewById<EditText>(R.id.nameEdittext)
            val emailEditText = findViewById<EditText>(R.id.EditEmailtext)
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            if (name.isNotEmpty() && email.isNotEmpty() ) {
                Toast.makeText(this, "Successfully added!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
        val imageView = findViewById<ImageView>(R.id.imageView)
        val editText = findViewById<EditText>(R.id.editText)

        imageView.setOnClickListener {
            val currentTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                LocalDateTime.now()
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            val formattedTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                currentTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm"))
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            editText.setText(formattedTime)
        }

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.setRating(3.5f)

        ratingBar.setOnRatingBarChangeListener { _, rating, fromUser ->
            if (fromUser) {
                Log.d("TAG", "Rating changed to $rating")
            }
        }
        val dropdown = findViewById<Spinner>(R.id.dropdown)
        val adapter = ArrayAdapter.createFromResource(
            this,
            years,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dropdown.adapter = adapter
        val editableforspinner: EditText = findViewById(R.id.editableforspinner)
        dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedYear = parent?.getItemAtPosition(position).toString()
                editableforspinner.setText(selectedYear)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedRating = when(checkedId) {
                R.id.radioButton1 -> 1
                R.id.radioButton2 -> 2
                R.id.radioButton3 -> 3
                R.id.radioButton4 -> 4
                R.id.radioButton5 -> 5
                R.id.radioButton6 -> 6
                else -> 0
            }
            selectedRating
        }
        menButton = findViewById(R.id.men_button)
        womenButton = findViewById(R.id.women_button)
        vectorImageView = findViewById(R.id.vector_image_view)

        menButton.setOnClickListener {
            vectorImageView.setImageResource(R.drawable.men)
            menButton.setBackgroundResource(R.color.Bluewhale)
            menButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            womenButton.setBackgroundResource(R.color.mythirdcolor)
            womenButton.setTextColor(ContextCompat.getColor(this, R.color.black))
        }

        womenButton.setOnClickListener {
            vectorImageView.setImageResource(R.drawable.women)
            menButton.setBackgroundResource(R.color.mythirdcolor)
            menButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            womenButton.setBackgroundResource(R.color.Bluewhale)
            womenButton.setTextColor(ContextCompat.getColor(this, R.color.white))
        }

        dobTextView = findViewById(R.id.dob_text_view)
        calendarImageView = findViewById(R.id.calendar_image_view)

        calendarImageView.setOnClickListener {
            showDatePickerDialog()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun showDatePickerDialog() {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%02d-%02d-%04d", selectedDay, selectedMonth + 1, selectedYear)
                dobTextView.text = formattedDate
            },
            year,
            month,
            day
        )

        datePickerDialog.show()


    }


}