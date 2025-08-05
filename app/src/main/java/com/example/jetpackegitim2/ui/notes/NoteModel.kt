package com.example.jetpackegitim2.ui.notes

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val note:String
)


