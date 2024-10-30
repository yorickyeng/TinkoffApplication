package com.example.myfirstapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.databinding.ItemViewBinding

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    private val jokes = mutableListOf<Joke>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<Joke>) {
        jokes.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(joke: Joke) {
        jokes.add(joke)
        notifyDataSetChanged()
    }

}