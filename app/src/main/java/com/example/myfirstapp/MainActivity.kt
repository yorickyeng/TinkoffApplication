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
        val newJokes = refreshJokes()

        val adapter = Adapter()
        binding.recyclerView.adapter = adapter
        adapter.setItems(jokeList)

        binding.button.setOnClickListener() {
            adapter.updateJokes(newJokes)
        }

    }

    private fun createJokeList(): List<Joke> {
        val jokeList = listOf(
            Joke(
                "Christmas",
                "What does Santa suffer from if he gets stuck in a chimney?",
                "Claustrophobia!",
                1
            ),
            Joke("Math", "What’s a math teacher’s favorite place in NYC?", "Times Square.", 2),
            Joke("Animals", "What do you call a fish wearing a bowtie?", "Sofishticated.", 3),
            Joke(
                "Tech",
                "What was the spider doing on the computer?",
                "He was making a web-site.",
                4
            ),
            Joke(
                "School",
                "Why did the student bring a ladder to school?",
                "Because he wanted to go to high school.",
                5
            ),
            Joke(
                "Science",
                "Why did the biologist break up with the physicist?",
                "There was no chemistry.",
                6
            ),
            Joke("Food", "What do you call cheese that isn’t yours?", "Nacho cheese.", 7)
        )

        return jokeList
    }

    private fun refreshJokes(): List<Joke> {
        val newJokes = listOf(
            Joke(
                "Christmas",
                "What does Santa suffer from if he gets stuck in a chimney?",
                "Claustrophobia!",
                1
            ),
            Joke("Animal", "Why did the chicken join a band?", "Because it had the drumsticks!", 2),
            Joke(
                "What",
                "Why did the scarecrow win an award?",
                "Because he was outstanding in his field!",
                3
            ),
            Joke("Food", "What do you call fake spaghetti?", " An impasta!", 5)
        )
        return newJokes
    }

}