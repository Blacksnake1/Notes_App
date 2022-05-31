package com.example.notesapp.local

import com.example.notesapp.NotesApp
import com.example.notesapp.db.NoteDatabase
import com.example.notesapp.model.NotesModel


class NoteLocal {
    private val noteDatabase = NoteDatabase.getInstance(NotesApp.getInstance())

    fun getAllNotes() : List<NotesModel>{
        return noteDatabase.noteDao().getAllNotes()
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