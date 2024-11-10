package com.example.myfirstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.databinding.ActivityJokeDetailsBinding

private const val JOKE_TITLE_KEY = "JOKE_TITLE"
private const val JOKE_QUESTION_KEY = "JOKE_QUESTION"
private const val JOKE_ANSWER_KEY = "JOKE_ANSWER"

class JokeDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJokeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Получаем данные из Intent
        val title = intent.getStringExtra(JOKE_TITLE_KEY)
        val question = intent.getStringExtra(JOKE_QUESTION_KEY)
        val answer = intent.getStringExtra(JOKE_ANSWER_KEY)

        // Устанавливаем полученные данные
        binding.category.text = title
        binding.question.text = question
        binding.answer.text = answer
    }

    companion object {
        fun newIntent(context: Context, title: String, question: String, answer: String): Intent {
            return Intent(context, JokeDetailsActivity::class.java).apply {
                putExtra(JOKE_TITLE_KEY, title)
                putExtra(JOKE_QUESTION_KEY, question)
                putExtra(JOKE_ANSWER_KEY, answer)
            }
        }
    }
}