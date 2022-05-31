package com.example.notesapp.ui.fragment.Home

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentHomeBinding
import com.example.notesapp.model.NotesModel
import com.example.notesapp.ui.Activity.DetailNoteActivity
import kotlin.math.log

class HomeFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    var listnote = ArrayList<NotesModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupEvent()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.noteList.observe(viewLifecycleOwner) { noteList ->
            Log.e("========> ", "setupUI: ${listnote.size} ")
            noteList.clear()
            noteList.addAll(listnote)
            homeAdapter?.notifyDataSetChanged()
        }

        viewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressLoading.isVisible = it
        }

        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllNote()

    }

    private fun setupUI() {
        setupRcvNotes()
    }

    private fun setupEvent() {
        binding.btnCreateNotes.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_creatNotesFragment)
        }
    }

    private fun setupRcvNotes() {
        homeAdapter = HomeAdapter(requireContext(), listnote, ::onClickItem)
        binding.rcvNotes.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = homeAdapter
        }

    }

    fun onClickItem(notesModel: NotesModel) {
        var intent = Intent(requireContext(), DetailNoteActivity::class.java)
        intent.putExtra("NOTEDETAIL", notesModel.id)
    }
}


