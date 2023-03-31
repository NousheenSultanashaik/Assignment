package com.example.practice

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.app.appsearch.AppSearchResult.RESULT_OK
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.provider.FontsContractCompat.FontRequestCallback.RESULT_OK
import java.text.SimpleDateFormat
import java.util.*
@Suppress("NAME_SHADOWING")
class MainActivity2 : AppCompatActivity() {
    private lateinit var dateAndTimeEditText: EditText
    private lateinit var dateAndTimeImageView: ImageView
    private lateinit var menButton: Button
    private lateinit var womenButton: Button
    private lateinit var vectorImageView: ImageView
    private lateinit var saveButton: Button
    @SuppressLint("SetTextI18n", "CutPasteId")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        saveButton = findViewById(R.id.saveButton)
        val name_edittext: EditText = findViewById(R.id.name_edittext)
        val email_edittext: EditText = findViewById(R.id.email_edittext)
        val maleButton: Button = findViewById(R.id.maleButton)
        val femaleButton: Button = findViewById(R.id.femaleButton)
        val btechYear_edittext: EditText = findViewById(R.id.btechpassout_edittext)
        val dob_edittext: EditText = findViewById(R.id.DOB_edittext)
        val dateandtime_edittext: EditText = findViewById(R.id.dateandtime_edittext)
        saveButton.setOnClickListener {
            val data = name_edittext.text.toString()
            val data1= email_edittext.text.toString()
            val data3 = btechYear_edittext.text.toString()
            val data4= dob_edittext.text.toString()
            val data5=dateAndTimeEditText.text.toString()
            val gender1 = when {
                maleButton.isPressed -> "Male"
                femaleButton.isPressed -> "Female"
                else -> ""
            }
            val resultIntent3 = Intent().apply {
                putExtra("gender", gender1)
            }

            val resultIntent1=Intent().apply {
                putExtra("data1",data1)
            }
            val resultIntent4 = Intent().apply {

                putExtra("data3",data3)
            }
            val resultIntent = Intent().apply {
                putExtra("data", data)
            }
            val resultIntent5= Intent().apply {
                putExtra("data4",data4)
            }
            val resultIntent6=Intent().apply {
                putExtra("data5",data5)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            setResult(Activity.RESULT_OK,resultIntent1)
            setResult(Activity.RESULT_OK,resultIntent3)
            setResult(Activity.RESULT_OK,resultIntent4)
            setResult(Activity.RESULT_OK, resultIntent3)
            setResult(Activity.RESULT_OK,resultIntent5)
            setResult(Activity.RESULT_OK,resultIntent6)
            finish()
            val name = name_edittext.text.toString().trim()
            val email = email_edittext.text.toString().trim()
            val gender = if (maleButton.isSelected) {
                "Male"
            } else if (femaleButton.isSelected) {
                "Female"
            } else {
                ""
            }
            val btechYear = btechYear_edittext.text.toString().trim()
            val dob = dob_edittext.text.toString().trim()
            val dateAndTime = dateandtime_edittext.text.toString().trim()
            val rating = getRating()
            val rating1_imageview: ImageView = findViewById(R.id.rating1_imageview)
            val rating2_imageview: ImageView = findViewById(R.id.rating2_imageview)
            val rating3_imageview: ImageView = findViewById(R.id.rating3_imageview)
            val rating4_imageview: ImageView = findViewById(R.id.rating4_imageview)
            val rating5_imageview: ImageView = findViewById(R.id.rating5_imageview)
            val selfRating = when{
                rating1_imageview.isSelected -> 1
                rating2_imageview.isSelected -> 2
                rating3_imageview.isSelected -> 3
                rating4_imageview.isSelected -> 4
                rating5_imageview.isSelected -> 5
                else -> 0
            }

            if (name.isEmpty() || email.isEmpty() || gender.isEmpty() || btechYear.isEmpty() ||
                dob.isEmpty() || dateAndTime.isEmpty() || rating < 0 || selfRating < 0) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show()
            }
        }


        menButton = findViewById(R.id.maleButton)
        womenButton = findViewById(R.id.femaleButton)
        vectorImageView = findViewById(R.id.vector_image_view)
        menButton.setOnClickListener {
            vectorImageView.setImageResource(R.drawable.ic_male)
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
        val rating1ImageView: ImageView = findViewById(R.id.rating1_imageview)
        val rating2ImageView: ImageView = findViewById(R.id.rating2_imageview)
        val rating3ImageView: ImageView = findViewById(R.id.rating3_imageview)
        val rating4ImageView: ImageView = findViewById(R.id.rating4_imageview)
        val rating5ImageView: ImageView = findViewById(R.id.rating5_imageview)
        val emptyCircleDrawable = ContextCompat.getDrawable(this, R.drawable.empty_circle)
        val filledCircleDrawable = ContextCompat.getDrawable(this, R.drawable.filled_circle)
        fun setRating(rating: Int) {
            rating1ImageView.setImageDrawable(emptyCircleDrawable)
            rating2ImageView.setImageDrawable(emptyCircleDrawable)
            rating3ImageView.setImageDrawable(emptyCircleDrawable)
            rating4ImageView.setImageDrawable(emptyCircleDrawable)
            rating5ImageView.setImageDrawable(emptyCircleDrawable)
            when (rating) {
                1 -> rating1ImageView.setImageDrawable(filledCircleDrawable)
                2 -> rating2ImageView.setImageDrawable(filledCircleDrawable)
                3 -> rating3ImageView.setImageDrawable(filledCircleDrawable)
                4 -> rating4ImageView.setImageDrawable(filledCircleDrawable)
                5 -> rating5ImageView.setImageDrawable(filledCircleDrawable)
            }
        }

        rating1ImageView.setOnClickListener {
            setRating(1)
        }

        rating2ImageView.setOnClickListener {
            setRating(2)
        }

        rating3ImageView.setOnClickListener {
            setRating(3)
        }

        rating4ImageView.setOnClickListener {
            setRating(4)
        }
        rating5ImageView.setOnClickListener {
            setRating(5)
        }
        val ratingValue = 3.4
        val star1 = findViewById<ImageView>(R.id.star1)
        val star2 = findViewById<ImageView>(R.id.star2)
        val star3 = findViewById<ImageView>(R.id.star3)
        val star4 = findViewById<ImageView>(R.id.star4)
        val star5 = findViewById<ImageView>(R.id.star5)
        val filledStars = ratingValue.toInt()
        star1.setImageResource(if (filledStars >= 1) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star2.setImageResource(if (filledStars >= 2) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star3.setImageResource(if (filledStars >= 3) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star4.setImageResource(if (filledStars >= 5) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star5.setImageResource(if (filledStars >= 5) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star1.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_empty)
            star3.setImageResource(R.drawable.ic_star_empty)
            star4.setImageResource(R.drawable.ic_star_empty)
            star5.setImageResource(R.drawable.ic_star_empty)
        }
        star2.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_filled)
            star3.setImageResource(R.drawable.ic_star_empty)
            star4.setImageResource(R.drawable.ic_star_empty)
            star5.setImageResource(R.drawable.ic_star_empty)
        }
        star3.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_filled)
            star3.setImageResource(R.drawable.ic_star_filled)
            star4.setImageResource(R.drawable.ic_star_empty)
            star5.setImageResource(R.drawable.ic_star_empty)
        }
        star4.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_filled)
            star3.setImageResource(R.drawable.ic_star_filled)
            star4.setImageResource(R.drawable.ic_star_filled)
            star5.setImageResource(R.drawable.ic_star_empty)
        }
        star5.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_filled)
            star3.setImageResource(R.drawable.ic_star_filled)
            star4.setImageResource(R.drawable.ic_star_filled)
            star5.setImageResource(R.drawable.ic_star_filled)
        }
        dateAndTimeEditText = findViewById(R.id.dateandtime_edittext)
        dateAndTimeImageView = findViewById(R.id.dateandtimeImageView)
        dateAndTimeImageView.setOnClickListener {
            showDateTimePicker()
        }
        val dobEditText = findViewById<EditText>(R.id.DOB_edittext)
        val calendarImageView = findViewById<ImageView>(R.id.calendarImageView)
        calendarImageView.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
                // Update the EditText with the selected date
                val formattedDate = "%02d-%02d-%d".format(dayOfMonth, month + 1, year)
                dobEditText.setText(formattedDate)
            }, year, month, dayOfMonth)

            datePickerDialog.show()
        }

        val btechPassoutYearEditText = findViewById<EditText>(R.id.btechpassout_edittext)

        btechPassoutYearEditText.setOnClickListener {
            showYearPicker(btechPassoutYearEditText)
        }
    }





    private fun getRating(): Int {
        var rating = 0
        val star1 = findViewById<ImageView>(R.id.star1)
        val star2 = findViewById<ImageView>(R.id.star2)
        val star3 = findViewById<ImageView>(R.id.star3)
        val star4 = findViewById<ImageView>(R.id.star4)
        val star5 = findViewById<ImageView>(R.id.star5)

        if (star1.isSelected) {
            rating = 1
        } else if (star2.isSelected) {
            rating = 2
        } else if (star3.isSelected) {
            rating = 3
        } else if (star4.isSelected) {
            rating = 4
        } else if (star5.isSelected) {
            rating = 5
        }
        return rating

    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun showDateTimePicker() {
        val currentDateAndTime = Calendar.getInstance()
        val currentYear = currentDateAndTime.get(Calendar.YEAR)
        val currentMonth = currentDateAndTime.get(Calendar.MONTH)
        val currentDayOfMonth = currentDateAndTime.get(Calendar.DAY_OF_MONTH)
        val currentHour = currentDateAndTime.get(Calendar.HOUR_OF_DAY)
        val currentMinute = currentDateAndTime.get(Calendar.MINUTE)
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val timePickerDialog = TimePickerDialog(
                    this,
                    { _, hourOfDay, minute ->
                        val selectedDateTime = Calendar.getInstance()
                        selectedDateTime.set(year, month, dayOfMonth, hourOfDay, minute)
                        val dateTimeFormat =
                            SimpleDateFormat("dd-MM-yyyy | HH:mm", Locale.getDefault())
                        dateAndTimeEditText.setText(dateTimeFormat.format(selectedDateTime.time))
                    },
                    currentHour,
                    currentMinute,
                    true
                )
                timePickerDialog.show()
            },
            currentYear,
            currentMonth,
            currentDayOfMonth
        )
        datePickerDialog.show()
    }

    private fun showYearPicker(editText: EditText) {
        val yearMenu = PopupMenu(this, editText)
        yearMenu.menuInflater.inflate(R.menu.year_menu, yearMenu.menu)
        yearMenu.setOnMenuItemClickListener { menuItem ->
            editText.setText(menuItem.title)

            true
        }
        yearMenu.show()
    }
}