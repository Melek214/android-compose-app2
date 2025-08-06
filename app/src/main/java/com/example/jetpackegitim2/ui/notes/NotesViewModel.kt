package com.example.jetpackegitim2.ui.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackegitim2.model.NoteModel
import com.example.jetpackegitim2.usecase.AddNotesUseCase
import com.example.jetpackegitim2.usecase.DeleteNoteUseCase
import com.example.jetpackegitim2.usecase.GetNoteUseCase
import com.example.jetpackegitim2.usecase.GetNotesUseCase
import com.example.jetpackegitim2.usecase.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private  val getNotesUseCase: GetNotesUseCase,
    private val addNotesUseCase: AddNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private  val getNoteUseCase: GetNoteUseCase,
): ViewModel() {
    private val _notes= mutableStateOf<List<NoteModel>>(emptyList())
    val notes:State<List<NoteModel>> = _notes

    private val _notesDetail= mutableStateOf<NoteModel?>(null)
    val notesDetail:State<NoteModel?> = _notesDetail


    init {
        getAllNotes()
    }

    private  fun getAllNotes() {
        viewModelScope.launch(){
            _notes.value = getNotesUseCase()
        }
    }

    internal fun getNote(id: Int) {
        viewModelScope.launch(){
            _notesDetail.value = getNoteUseCase(id)
        }
    }


    fun addNote(text: String, detail: String){
        viewModelScope.launch {
            addNotesUseCase(note= NoteModel(noteTitle=text, noteDetail = detail))
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

