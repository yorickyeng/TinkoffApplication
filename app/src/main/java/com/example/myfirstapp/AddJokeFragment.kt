package com.example.myfirstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.util.UUID

class AddJokeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_add_joke, container, false)

        val editTextCategory = view.findViewById<EditText>(R.id.editTextCategory)
        val editTextQuestion = view.findViewById<EditText>(R.id.editTextQuestion)
        val editTextAnswer = view.findViewById<EditText>(R.id.editTextAnswer)
        val buttonSaveJoke = view.findViewById<Button>(R.id.buttonSaveJoke)

        buttonSaveJoke.setOnClickListener {
            val category = editTextCategory.text.toString()
            val question = editTextQuestion.text.toString()
            val answer = editTextAnswer.text.toString()

            if (category.isNotEmpty() && question.isNotEmpty() && answer.isNotEmpty()) {
                val newJoke = Joke(
                    category = category,
                    question = question,
                    answer = answer,
                    id = UUID.randomUUID().toString()
                )
                JokeRepository.addJoke(newJoke)
                (requireActivity() as? MainActivity)?.refreshJokeList()
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        return view
    }
}
