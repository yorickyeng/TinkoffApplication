package com.example.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.databinding.ItemViewBinding

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    private var jokes = mutableListOf<Joke>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount() = jokes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(jokes[position])

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, JokeDetailsActivity::class.java).apply {
                putExtra("JOKE_TITLE", jokes[position].category)
                putExtra("JOKE_QUESTION", jokes[position].question)
                putExtra("JOKE_ANSWER", jokes[position].answer)
            }
            context.startActivity(intent)
        }

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

    fun updateJokes(newJokes: List<Joke>) {
        val diffResult = DiffUtil.calculateDiff(JokeDiffUtilCallback(jokes, newJokes))
        jokes = newJokes.toMutableList()
        diffResult.dispatchUpdatesTo(this)
    }

}