package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class AddJokeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_joke)

        val editTextCategory = findViewById<EditText>(R.id.editTextCategory)
        val editTextQuestion = findViewById<EditText>(R.id.editTextQuestion)
        val editTextAnswer = findViewById<EditText>(R.id.editTextAnswer)
        val buttonSaveJoke = findViewById<Button>(R.id.buttonSaveJoke)

        buttonSaveJoke.setOnClickListener {
            val category = editTextCategory.text.toString()
            val question = editTextQuestion.text.toString()
            val answer = editTextAnswer.text.toString()

            if (category.isNotEmpty() && question.isNotEmpty() && answer.isNotEmpty()) {
                val newJoke = Joke(
                    category = category,
                    question = question,
                    answer = answer,
                    id = UUID.randomUUID().toString()
                )
                JokeRepository.addJoke(newJoke)
                finish() // Возврат на главный экран
            }
        }
    }
}