package com.example.myfirstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myfirstapp.databinding.FragmentJokeDetailsBinding

class JokeDetailsFragment : Fragment() {
    private var _binding: FragmentJokeDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJokeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString(JOKE_CATEGORY_KEY)
        val question = arguments?.getString(JOKE_QUESTION_KEY)
        val answer = arguments?.getString(JOKE_ANSWER_KEY)

        binding.category.text = title
        binding.question.text = question
        binding.answer.text = answer
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val JOKE_CATEGORY_KEY = "JOKE_CATEGORY"
        private const val JOKE_QUESTION_KEY = "JOKE_QUESTION"
        private const val JOKE_ANSWER_KEY = "JOKE_ANSWER"

        fun newInstance(title: String, question: String, answer: String): JokeDetailsFragment {
            return JokeDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(JOKE_CATEGORY_KEY, title)
                    putString(JOKE_QUESTION_KEY, question)
                    putString(JOKE_ANSWER_KEY, answer)
                }
            }
        }
    }
}
