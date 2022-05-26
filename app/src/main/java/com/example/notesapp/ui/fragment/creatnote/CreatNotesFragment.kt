package com.example.notesapp.ui.fragment.creatnote

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentCreatNotesBinding

import java.util.*


class CreatNotesFragment : Fragment() {
    private lateinit var binding: FragmentCreatNotesBinding
    var priority : String = "1"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatNotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupEvent()
    }


    private fun setupObserver() {

    }


    private fun setupEvent() {
        binding.btnCreateNotes.setOnClickListener {
            createNote(it)
        }
        binding.imgGreenDot.setImageResource(R.drawable.ic_baseline_check_24)

        binding.imgGreenDot.setOnClickListener {
            priority = "1"
            binding.imgGreenDot.setImageResource(R.drawable.ic_baseline_check_24)
            binding.imgRedDot.setImageResource(0)
            binding.imgYellowDot.setImageResource(0)

        }
        binding.imgRedDot.setOnClickListener {
            priority = "2"
            binding.imgGreenDot.setImageResource(0)
            binding.imgRedDot.setImageResource(R.drawable.ic_baseline_check_24)
            binding.imgYellowDot.setImageResource(0)

        }
        binding.imgYellowDot.setOnClickListener {
            priority = "3"
            binding.imgGreenDot.setImageResource(0)
            binding.imgRedDot.setImageResource(0)
            binding.imgYellowDot.setImageResource(R.drawable.ic_baseline_check_24)
        }
        binding.btnCreateNotes.setOnClickListener {

        }
    }
    private fun createNote(it: View?) {
        val title = binding.edCreateTitle.text
        val subtitle = binding.edCreateSub.text
        val contentNote = binding.btnCreateNotes.text
        val d = Date()
        val noteDate: CharSequence = DateFormat.format("mmm dd, yyyy", d.time)

    }



}