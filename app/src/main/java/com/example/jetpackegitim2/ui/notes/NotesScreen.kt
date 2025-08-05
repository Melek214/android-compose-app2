package com.example.jetpackegitim2.ui.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NotesScreen(viewModel: NotesViewModel= hiltViewModel()) {
    val noteUiState by viewModel.notes
    var text by remember {
        mutableStateOf("")
    }

    LazyColumn {
        item {
            TextField(value = text, onValueChange = {
                text = it
            })
            Button(onClick = { viewModel.addNote(text) }) {
                Text(text = "Not Kayıt Et")

            }
        }

        items(noteUiState) {
            Text(modifier = Modifier.clickable {
                viewModel.deleteNote(id=it.id)
            }, text = it.note)
            Button(onClick = {
                viewModel.updateNote(it.copy(note = "${it.note} Güncellendi"))
            }) {
                Text(text = "Güncelle")
                
            }
        }
    }
}