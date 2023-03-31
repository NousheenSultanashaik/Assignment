package com.example.myquizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MyQuizQuestions : AppCompatActivity(), View.OnClickListener{
    private var mCurrentposition: Int = 1
    private var mquestionlist : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var progressBar : ProgressBar? = null
    private var tvprogress : TextView? = null
    private var tvquestion : TextView? = null
    private var tvoptionone : TextView? = null
    private var tvoptiontwo : TextView? = null
    private var tvoptionthree : TextView? = null
    private var tvoptionfour : TextView? = null
    private var btnsubmit : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_quiz_questions)
        progressBar = findViewById(R.id.progressbar)
        tvprogress = findViewById(R.id.tv_progress)
        tvquestion = findViewById(R.id.tv_question)
        tvoptionone = findViewById(R.id.tv_optionone)
        tvoptiontwo = findViewById(R.id.tv_optiontwo)
        tvoptionthree = findViewById(R.id.tv_optionthree)
        tvoptionfour = findViewById(R.id.tv_optionfour)
        btnsubmit = findViewById(R.id.btn_submit)
        tvoptionone?.setOnClickListener { this }
        tvoptiontwo?.setOnClickListener { this }
        tvoptionthree?.setOnClickListener { this }
        tvoptionfour?.setOnClickListener { this }
        btnsubmit?.setOnClickListener { this }

        val questionsList = Constraints.getQuestions()
        Log.i("questionsList size","${questionsList.size}")
        for( i in questionsList){
            Log.e("Questions", i.question)
        }
        val currentposition = 1
        val question : Question = questionsList[currentposition-1]
        progressBar?.progress = currentposition
        tvprogress?.text = "$currentposition/${progressBar?.max}"
        tvquestion?.text = question.question
        tvoptionone?.text= question.optionone
        tvoptiontwo?.text= question.optiontwo
        tvoptionthree?.text= question.optionthree
        tvoptionfour?.text= question.optionfour

        if (mCurrentposition == mquestionlist!!.size) {
            btnsubmit?.text = "finish"
        } else {
            btnsubmit?.text = "submit"
        }
        defaultoptionsview()
    }

    private fun defaultoptionsview(){
        val option = ArrayList<TextView>()
        tvoptionone?.let {
            option.add(0,it)
        }
        tvoptiontwo?.let {
            option?.add(0,it)
        }
        tvoptionthree?.let {
            option?.add(0,it)
        }
        tvoptionfour?.let {
            option.add(0,it)
        }
        for(option in option){
            option.setTextColor(Color.parseColor("#FF800606"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
        }

    }
    private fun selectedoptionview(tv: TextView,selectedoptionnum:Int){
        defaultoptionsview()
        mSelectedOptionPosition = selectedoptionnum
        tv.setTextColor(Color.parseColor("#FF800606"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }


    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tv_optionone -> {
                tvoptionone.let {
                    if (it != null) {
                        selectedoptionview(it, 1)
                    }
                }
            }

                R.id.tv_optiontwo -> {
                    tvoptiontwo.let {
                        if (it != null) {
                            selectedoptionview(it, 2)
                        }
                    }
                }
                    R.id.tv_optionthree ->{
                    tvoptionthree.let {
                        if (it != null) {
                            selectedoptionview(it, 3)
                        }
                    }
                }
            R.id.tv_optionthree ->{
                tvoptionthree.let {
                    if (it != null) {
                        selectedoptionview(it,4)
                    }
                }
                }
            R.id.btn_submit ->{
                "TODO Impliment button submit"

                }
            }
            }

    }
