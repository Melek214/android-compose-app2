package com.example.jetpackegitim2.di

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.jetpackegitim2.model.NoteModel

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes" )
    suspend fun getAllNotes():List<NoteModel>

    @Insert
    suspend fun addNote(noteModel: NoteModel)

    @Query("Delete From notes Where id=:id")
    suspend fun deleteNote(id:Int)

    @Update
    suspend fun updateNote(noteModel: NoteModel)

    @Query("SELECT * FROM notes Where id=:id" )
    suspend fun getNotes(id: Int):NoteModel



}

