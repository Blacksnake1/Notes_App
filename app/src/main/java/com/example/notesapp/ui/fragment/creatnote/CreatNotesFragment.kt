package com.example.notesapp.ui.fragment.creatnote

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentCreatNotesBinding
import com.example.notesapp.model.NotesModel

import java.util.*


class CreatNotesFragment : Fragment() {
    private val viewmodel by lazy {
        ViewModelProvider(this)[CreatNotesVM::class.java]
    }
    private lateinit var binding: FragmentCreatNotesBinding
    var priority: String = "1"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatNotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupEvent()
        setupObserver()
    }

    private fun setupObserver() {
        viewmodel.noteInsertValue.observe(viewLifecycleOwner) {
            Log.e("========> ", "noteInsertValue: $it ")
            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
        }

        viewmodel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
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
    }

    private fun createNote(it: View?) {

        val title = binding.editCreateTitle.text.toString()
        val subtitle = binding.editCreateSub.text
        val contentNote = binding.editCreateNote.text.toString()
        val d = Date()
        val noteDate: CharSequence = DateFormat.format("mm dd yyyy", d.time)

        val data = NotesModel(
            title    = title,
            subtitle = subtitle.toString(),
            note     = contentNote,
            date     = noteDate.toString(),
            priority = priority)

        if( contentNote.isEmpty()){
            Toast.makeText(requireContext(),"Empty",Toast.LENGTH_SHORT).show()
        } else{
            viewmodel.insertNotes(data)
            Navigation.findNavController(it!!).navigate(R.id.action_creatNotesFragment_to_homeFragment)
        }

    }
}