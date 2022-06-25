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
// ban đầu nó sẽ hiện cái isloading quay quay, sau đo khi dữ liệu đã đổ về thì isloading sẽ ẩn đi
// và chạy vào ở try..catch.

//        setValue chay trên mainthread, postvalue chạy trên backgroud thread.

//        noteInsertValue được gắn kiểu Long và được lấy dữ liệu của dòng 31 hoặc có thể hiểu là
//        noteInsertValue sẽ đẩy dữ liệu lên thằng quan sát nó giá trị
//        là notesResponsitory.insertNote(notesModel)

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


