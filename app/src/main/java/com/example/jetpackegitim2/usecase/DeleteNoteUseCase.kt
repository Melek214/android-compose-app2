package com.example.jetpackegitim2.usecase

import com.example.jetpackegitim2.di.NotesRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val notesRepository: NotesRepository){
    suspend operator fun invoke(id:Int) = notesRepository.deleteNote(id)
}