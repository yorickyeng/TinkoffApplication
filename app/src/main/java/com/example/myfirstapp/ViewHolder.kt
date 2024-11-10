package com.example.myfirstapp

import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.databinding.ItemViewBinding

class ViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(joke: Joke) {
        binding.categoryTextView.text = joke.category
        binding.questionTextView.text = joke.question
        binding.answerTextView.text = joke.answer

        itemView.setOnClickListener {
            val intent = JokeDetailsActivity.newIntent(
                itemView.context,
                joke.category,
                joke.question,
                joke.answer
            )
            itemView.context.startActivity(intent)
        }
    }

}