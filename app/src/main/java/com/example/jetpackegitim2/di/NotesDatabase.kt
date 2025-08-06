package com.example.jetpackegitim2.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackegitim2.model.NoteModel

@Database(entities = [NoteModel::class], version = 1, exportSchema = false)
abstract class NotesDatabase:RoomDatabase() {
    abstract fun notesDao(): NotesDao

}