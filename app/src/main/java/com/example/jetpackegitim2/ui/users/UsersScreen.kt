package com.example.jetpackegitim2.ui.users

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UsersScreen (viewModel: UsersViewModel= hiltViewModel()){
    val users=viewModel.users

    LazyColumn {
        items(users.value){ user->
            Text(text = user.name)
        }
    }
    Text(text = "Kullanıcı Listesi")
}
