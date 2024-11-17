package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var emptyTextView: TextView
    private lateinit var buttonAddJoke: Button
    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        emptyTextView = findViewById(R.id.emptyTextView)
        buttonAddJoke = findViewById(R.id.buttonAddJoke)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        buttonAddJoke.setOnClickListener {
            startActivity(Intent(this, AddJokeActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        loadJokes()
    }

    private fun loadJokes() {
        progressBar.visibility = View.VISIBLE
        emptyTextView.visibility = View.GONE

        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            val jokes = withContext(Dispatchers.IO) {
                JokeRepository.getAllJokes()
            }
            progressBar.visibility = View.GONE
            if (jokes.isEmpty()) {
                emptyTextView.visibility = View.VISIBLE
            } else {
                adapter.submitList(jokes)
            }
        }
    }

    fun onJokeClick(joke: Joke) {
        val intent = JokeDetailsActivity.newIntent(
            this,
            joke.category,
            joke.question,
            joke.answer
        )
        startActivity(intent)
    }
}
