package com.example.jetpackegitim2.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val noteTitle:String,
    val noteDetail:String
)


