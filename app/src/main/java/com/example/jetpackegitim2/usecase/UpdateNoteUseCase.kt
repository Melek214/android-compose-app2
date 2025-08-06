package com.example.jetpackegitim2.usecase

import com.example.jetpackegitim2.model.NoteModel
import com.example.jetpackegitim2.di.NotesRepository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(private val notesRepository: NotesRepository){
    suspend operator fun invoke(note: NoteModel) = notesRepository.updateNote(note)
}