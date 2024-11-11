package com.example.myfirstapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JokeViewModel : ViewModel() {

    private val _jokes = MutableLiveData<List<Joke>>()
    val jokes: LiveData<List<Joke>> = _jokes

    init {
        _jokes.value = JokeRepository().getInitialJokes()
    }

    fun updateJokes() {
        _jokes.value = JokeRepository().getUpdatedJokes()
    }
}
