package com.example.myfirstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragmentContainer, JokesListFragment())
            }
        }
    }

    fun onJokeClick(joke: Joke) {
        val jokeDetailsFragment = JokeDetailsFragment.newInstance(
            joke.category,
            joke.question,
            joke.answer
        )
        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, jokeDetailsFragment)
            addToBackStack(null)
        }
    }
}
