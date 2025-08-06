package com.example.jetpackegitim2.usecase

import com.example.jetpackegitim2.model.NoteModel
import com.example.jetpackegitim2.di.NotesRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val notesRepository: NotesRepository){
    suspend operator fun invoke():List<NoteModel> = notesRepository.getAllNotes()
}