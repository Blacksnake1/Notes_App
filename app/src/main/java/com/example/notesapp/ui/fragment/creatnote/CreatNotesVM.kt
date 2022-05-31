package com.example.notesapp.ui.fragment.creatnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.model.NotesModel
import com.example.notesapp.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CreatNotesVM(
    private val notesResponsitory: NoteRepository = NoteRepository()
) : ViewModel() {
    var noteInsertValue = MutableLiveData<Long>()
    var errorLiveData = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()

    fun insertNotes(notesModel: NotesModel) {
//khi có dữ liệu thì isloading sẽ cho chạy dòng cụm launch, còn khi nó false thì chạy catch
//        setValue chay trên mainthread, postvalue chạy trên backgroud thread
        isLoading.postValue(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                isLoading.postValue(false)
                try {
                    noteInsertValue.postValue( notesResponsitory.insertNote(notesModel))

                }catch (e : Exception){
                    errorLiveData.postValue(e.message)
                }
            }
        }
    }
}


