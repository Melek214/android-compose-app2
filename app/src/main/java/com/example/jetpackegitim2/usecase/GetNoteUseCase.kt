package com.example.jetpackegitim2.usecase

import com.example.jetpackegitim2.di.NotesRepository
import com.example.jetpackegitim2.model.NoteModel
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(private val notesRepository: NotesRepository){
    suspend operator fun invoke(id: Int): NoteModel = notesRepository.getNotes(id)
}