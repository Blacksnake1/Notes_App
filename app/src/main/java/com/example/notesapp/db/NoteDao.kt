package com.example.notesapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesapp.model.NotesModel

@Dao
interface NoteDao {
    @Query ("SELECT * FROM Notes")
    fun getAllNotes(): List<NotesModel>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertNote (notesModel: NotesModel) : Long

    @Query ( "DELETE FROM Notes WHERE id=:id ")
    fun deleteNote(id:Int)

    @Update
    fun updateNote(notesModel: NotesModel)
}