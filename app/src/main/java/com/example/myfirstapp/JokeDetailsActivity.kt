package com.example.myfirstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.databinding.ActivityJokeDetailsBinding

class JokeDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJokeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Получаем данные из Intent
        val title = intent.getStringExtra("JOKE_TITLE")
        val question = intent.getStringExtra("JOKE_QUESTION")
        val answer = intent.getStringExtra("JOKE_ANSWER")

        // Устанавливаем полученные данные
        binding.category.text = title
        binding.question.text = question
        binding.answer.text = answer
    }
}