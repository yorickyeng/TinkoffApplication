package com.example.myfirstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myfirstapp.databinding.FragmentJokesListBinding

class JokesListFragment : Fragment() {
    private var _binding: FragmentJokesListBinding? = null
    private val binding get() = _binding!!
    private val jokeViewModel: JokeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJokesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = Adapter()

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerView.adapter = adapter

        jokeViewModel.jokes.observe(viewLifecycleOwner) { jokes ->
            adapter.setItems(jokes)
        }

        binding.refreshButton.setOnClickListener {
            val newJokes = JokeRepository().getUpdatedJokes()
            jokeViewModel.updateJokes(newJokes)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
