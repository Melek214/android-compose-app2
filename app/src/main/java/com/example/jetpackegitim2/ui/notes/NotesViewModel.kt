package com.example.jetpackegitim2.ui.notes

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackegitim2.ui.notes.usecase.AddNotesUseCase
import com.example.jetpackegitim2.ui.notes.usecase.DeleteNoteUseCase
import com.example.jetpackegitim2.ui.notes.usecase.GetNotesUseCase
import com.example.jetpackegitim2.ui.notes.usecase.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private  val getNotesUseCase: GetNotesUseCase,
    private val addNotesUseCase: AddNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
): ViewModel() {
    private val _notes= mutableStateOf<List<NoteModel>>(emptyList())
    val notes:State<List<NoteModel>> = _notes

    init {
        getAllNotes()
    }

    private  fun getAllNotes() {
        viewModelScope.launch(){
            _notes.value = getNotesUseCase()
        }
    }


    fun addNote(text:String){
        viewModelScope.launch {
            addNotesUseCase(note=NoteModel(note=text))
            getNotesUseCase()
        }
    }

    fun deleteNote(id:Int){
        viewModelScope.launch {
            deleteNoteUseCase(id)
            getAllNotes()
        }
    }

    fun updateNote(noteModel: NoteModel){
        viewModelScope.launch {
           updateNoteUseCase(noteModel)
            getAllNotes()
        }
    }
}

