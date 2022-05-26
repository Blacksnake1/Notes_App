package com.example.notesapp.ui.fragment.Home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
        setupEvent()
        init()
    }



    private fun setupUI() {
        setupRcvNotes()
    }

    private fun setupObserver() {

    }

    private fun setupEvent() {

    }

    private fun init() {
        binding.btnCreateNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_creatNotesFragment)
        }
    }

    private fun setupRcvNotes() {

    }
}