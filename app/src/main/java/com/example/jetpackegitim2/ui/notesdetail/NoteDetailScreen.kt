package com.example.jetpackegitim2.ui.notesdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackegitim2.ui.notes.NotesViewModel

@Composable
fun NoteDetailScreen(viewModel: NotesViewModel = hiltViewModel(), id: Int) {

    viewModel.getNote(id = id)

    val noteUiState by viewModel.notesDetail


    if (noteUiState != null) {
        val note = noteUiState!!

        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(text = note.noteTitle, fontSize = 22.sp)
            Spacer(modifier = Modifier.size(16.dp))

            Text(text = note.noteDetail, fontSize = 16.sp)
            Spacer(modifier = Modifier.size(24.dp))

            Button(onClick = {
                viewModel.deleteNote(note.id)
            }) {
                Text("Sil")
            }

            Spacer(modifier = Modifier.size(12.dp))

            Button(onClick = {
                viewModel.updateNote(
                    note.copy(
                        noteTitle = note.noteTitle + " (Güncellendi)",
                        noteDetail = note.noteDetail + "\nGüncelleme tarihi: " + System.currentTimeMillis()
                    )
                )
            }) {
                Text("Güncelle")
            }
        }
    }
}
