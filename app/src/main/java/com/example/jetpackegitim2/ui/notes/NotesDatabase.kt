package com.example.jetpackegitim2.ui.notes

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteModel::class], version = 1, exportSchema = false)
abstract class NotesDatabase:RoomDatabase() {
    abstract fun notesDao():NotesDao

}