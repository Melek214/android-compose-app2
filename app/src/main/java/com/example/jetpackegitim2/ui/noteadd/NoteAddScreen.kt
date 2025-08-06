package com.example.jetpackegitim2.ui.noteadd

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackegitim2.ui.notes.NotesViewModel

@Composable
fun NoteAddScreen(viewModel: NotesViewModel = hiltViewModel(), navigateHome: () -> Unit) {
    var text by remember {
        mutableStateOf("")
    }

    var detail by remember {
        mutableStateOf("")
    }

    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            TextField(modifier = Modifier.fillMaxWidth(), value = text, label = {
                Text(text = "Başlık")
            }, onValueChange = {
                text = it
            })

            Spacer(modifier = Modifier.size(8.dp))

            TextField(modifier = Modifier.fillMaxWidth(), value = detail, label = {
                Text(text = "Detay")
            }, onValueChange = {
                detail = it
            })

            Spacer(modifier = Modifier.size(16.dp))

            Button(onClick = {
                viewModel.addNote(text, detail)
                navigateHome()
            }) {
                Text(text = "Not Kayıt Et", fontSize = 22.sp)
            }
        }
    }
}