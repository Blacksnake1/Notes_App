package com.example.notesapp.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.R
import com.example.notesapp.databinding.ActivityDetailNoteBinding
import com.example.notesapp.model.NotesModel

class DetailNoteActivity : AppCompatActivity() {
    var notes : NotesModel? = null
    private lateinit var binding: ActivityDetailNoteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_note)
        setupUi()
        setupEvent()
    }

    private fun setupUi() {
        notes = intent.getSerializableExtra("NOTEDETAIL") as NotesModel?
        notes?.let {
            showNote(it)
        }
    }

    private fun setupEvent() {
        initControl()


    }

    private fun initControl() {
//        binding.btnEditNote.setOnClickListener {
//            var intent = Intent(this, EditNotesFragment::class.java)
//            intent.putExtra("NOTEEDIT", notes)
//            startActivity(intent)
//       }
    }

    private fun showNote(it: NotesModel) {
        binding.editDetailTitle.text = it.title
        binding.editDetailSub.text = it.subtitle
        binding.tvEditNote.text = it.note
        when (it.priority) {
            "1" -> {
                binding.imgGreenDot.setImageResource(R.drawable.ic_baseline_check_24)
            }
            "2" -> {
                binding.imgRedDot.setImageResource(R.drawable.ic_baseline_check_24)
            }
            "3" -> {
                binding.imgYellowDot.setImageResource(R.drawable.ic_baseline_check_24)
            }
        }

    }


}