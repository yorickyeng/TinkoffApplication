package com.example.myfirstapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JokeViewModel : ViewModel() {
    private val repository = JokeRepository()
    private val _jokes = MutableLiveData<List<Joke>>()
    val jokes: LiveData<List<Joke>> get() = _jokes

    init {
        _jokes.value = repository.getInitialJokes()
    }

    fun refreshJokes() {
        _jokes.value = repository.getUpdatedJokes()
    }

}