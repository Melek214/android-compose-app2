package com.example.jetpackegitim2.di

import com.example.jetpackegitim2.model.NoteModel
import javax.inject.Inject

class NotesRepository @Inject constructor(private val notesDao: NotesDao) {

    suspend fun getAllNotes():List<NoteModel> = notesDao.getAllNotes()

    suspend fun addNotes(noteModel: NoteModel){
        notesDao.addNote(noteModel)
    }

    suspend fun deleteNote(id:Int){
        notesDao.deleteNote(id)
    }

    suspend fun updateNote(noteModel: NoteModel){
        notesDao.updateNote(noteModel)
    }
    suspend fun getNotes(id: Int):NoteModel = notesDao.getNotes(id)
}