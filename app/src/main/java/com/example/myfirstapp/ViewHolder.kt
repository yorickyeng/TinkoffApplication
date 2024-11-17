package com.example.myfirstapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textCategory = itemView.findViewById<TextView>(R.id.categoryTextView)
    private val textQuestion = itemView.findViewById<TextView>(R.id.questionTextView)
    private val textAnswer = itemView.findViewById<TextView>(R.id.answerTextView)

    fun bind(joke: Joke) {
        textCategory.text = joke.category
        textQuestion.text = joke.question
        textAnswer.text = joke.answer

        itemView.setOnClickListener {
            (itemView.context as? MainActivity)?.onJokeClick(joke)
        }
    }
}