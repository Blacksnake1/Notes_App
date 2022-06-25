package com.example.notesapp.ui.fragment.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.model.NotesModel
import com.example.notesapp.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class HomeViewModel(
    private val noteRepository: NoteRepository = NoteRepository()
) : ViewModel() {
    var noteList = MutableLiveData<MutableList<NotesModel>>()
    var isLoading = MutableLiveData<Boolean>()
    var error = MutableLiveData<String>()



    fun getAllNote(){
        isLoading.postValue(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                isLoading.postValue(false)
                Log.e("========> ", "getAllNotes: ${noteRepository.getAllNotes().size} ")
                try {
                    noteList.postValue(noteRepository.getAllNotes())
                }catch (e : Exception){
                    error.postValue(e.message)
                }
            }

        }
    }



}