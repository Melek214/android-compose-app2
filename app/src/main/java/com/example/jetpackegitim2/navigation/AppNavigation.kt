package com.example.jetpackegitim2.navigation

enum class Screen {
    NOTE,
    NOTE_DETAIL,
    NOTE_ADD
}

sealed class NavigatioItem(val route: String) {
    object Note: NavigatioItem(Screen.NOTE.name)
    object NoteDetail: NavigatioItem(Screen.NOTE_DETAIL.name)
    object NoteAdd: NavigatioItem(Screen.NOTE_ADD.name)
}