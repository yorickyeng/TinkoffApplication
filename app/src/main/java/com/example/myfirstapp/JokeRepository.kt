package com.example.myfirstapp

class JokeRepository {

    companion object {
        private val jokes = mutableListOf<Joke>()

        fun addJoke(joke: Joke) {
            jokes.add(joke)
        }

        fun getAllJokes(): List<Joke> {
            return jokes
        }
    }

}