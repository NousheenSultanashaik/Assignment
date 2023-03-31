import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.R

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var answerButton: Button
    private lateinit var selectedRadioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.question_text_view)
        radioGroup = findViewById(R.id.radio_group)
        answerButton = findViewById(R.id.answer_button)

        answerButton.setOnClickListener {
            checkAnswer()
        }

        showNextQuestion()
    }

    private fun showNextQuestion() {
        questionTextView.text = "What is the capital of France?"

        val options = arrayOf("New York", "Paris", "London", "Tokyo")
        for (option in options) {
            val radioButton = RadioButton(this)
            radioButton.text = option
            radioGroup.addView(radioButton)
        }
    }

    private fun checkAnswer() {
        selectedRadioButton = findViewById(radioGroup.checkedRadioButtonId)

        if (selectedRadioButton.text == "Paris") {
            questionTextView.text = "Correct!"
        } else {
            questionTextView.text = "Incorrect. The correct answer is Paris."
        }
    }
}


