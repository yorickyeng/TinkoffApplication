package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.databinding.ItemViewBinding

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    private var jokes = mutableListOf<Joke>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val joke = jokes[position]
        holder.bind(joke)
    }

    override fun getItemCount(): Int = jokes.size

    fun setItems(list: List<Joke>) {
        val diffResult = DiffUtil.calculateDiff(JokeDiffUtilCallback(jokes, list))
        jokes.clear()
        jokes.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

}
