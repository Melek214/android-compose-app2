package com.example.jetpackegitim2.ui.notes.usecase

import com.example.jetpackegitim2.ui.notes.NoteModel
import com.example.jetpackegitim2.ui.notes.NotesRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val notesRepository: NotesRepository){
    suspend operator fun invoke():List<NoteModel> = notesRepository.getAllNotes()
}