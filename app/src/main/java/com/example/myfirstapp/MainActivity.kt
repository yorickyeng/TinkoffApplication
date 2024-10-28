package com.example.myfirstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 1)
        val jokeList = createJokeList()

        val adapter = Adapter()
        binding.recyclerView.adapter = adapter
        adapter.setItems(jokeList)

    }

    private fun createJokeList(): List<Joke> {
        val jokeList = listOf(
            Joke(
                "Christmas",
                "What does Santa suffer from if he gets stuck in a chimney?",
                "Claustrophobia!"
            ),
            Joke("Math", "What’s a math teacher’s favorite place in NYC?", "Times Square."),
            Joke("Animals", "What do you call a fish wearing a bowtie?", "Sofishticated."),
            Joke("Tech", "What was the spider doing on the computer?", "He was making a web-site."),
            Joke(
                "School",
                "Why did the student bring a ladder to school?",
                "Because he wanted to go to high school."
            ),
            Joke(
                "Science",
                "Why did the biologist break up with the physicist?",
                "There was no chemistry."
            ),
            Joke("Food", "What do you call cheese that isn’t yours?", "Nacho cheese.")
        )
        return jokeList
    }

}