package com.example.notesapp.local

import com.example.notesapp.NotesApp
import com.example.notesapp.model.NotesModel


class NoteLocal {
    private val noteDatabase = com.example.notesapp.db.NoteDatabase.getInstance(NotesApp.getInstance().applicationContext)

    fun getAllNotes() : MutableList<NotesModel>{
        return noteDatabase.noteDao().getAllNotes().toMutableList()
    }

    fun insertNote(notesModel: NotesModel) : Long{
        return noteDatabase.noteDao().insertNote(notesModel)
    }
    fun deleteNote(id:Int){
        return noteDatabase.noteDao().deleteNote(id)
    }
    fun updateNote(notesModel: NotesModel){
        return noteDatabase.noteDao().updateNote(notesModel)
    }
}