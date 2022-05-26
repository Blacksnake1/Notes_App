package com.example.notesapp

import android.app.Application


class NotesApp: Application() {
    override fun onCreate() {
        super.onCreate()
        instance= this
    }
    companion object{
        @Volatile
        private var instance : NotesApp? = null

        @JvmStatic
        fun getInstance(): NotesApp = instance?: synchronized(this){
            instance?: NotesApp(). also{
                instance = it }
        }

    }
}