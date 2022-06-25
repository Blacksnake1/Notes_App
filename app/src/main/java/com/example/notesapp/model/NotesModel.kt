package com.example.notesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName ="Notes")
class NotesModel  (
    @PrimaryKey (autoGenerate = true)
    var id : Int? = null,
    var title : String?,
    var subtitle: String?,
    var note: String?,
    var date: String?,
    var priority: String?
): Serializable
