package com.example.jetpackegitim2.ui.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userRepository : UserRepository
):ViewModel() {

    private  val _users= mutableStateOf<List<UserModel>>(emptyList())
    val users:State<List<UserModel>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers(){
        viewModelScope.launch {
            _users.value=userRepository.getUsers()

        }
    }

}