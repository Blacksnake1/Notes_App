package com.example.notesapp.repository

import com.example.notesapp.local.NoteLocal
import com.example.notesapp.model.NotesModel

class NoteRepository {
    private var notesLocal: NoteLocal = NoteLocal()

    fun getAllNotes() : MutableList<NotesModel>{
        return notesLocal.getAllNotes().toMutableList()
    }

    fun insertNote(notesModel: NotesModel) : Long{
        return notesLocal.insertNote(notesModel)
    }
    fun deleteNote(id:Int){
        return notesLocal.deleteNote(id)
    }
    fun updateNote(notesModel: NotesModel){
        return notesLocal.updateNote(notesModel)
    }
}