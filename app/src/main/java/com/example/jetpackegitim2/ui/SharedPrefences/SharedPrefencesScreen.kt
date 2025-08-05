package com.example.jetpackegitim2.ui.SharedPrefences

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun SharedPrefencesScreen() {
    val contex= LocalContext.current
    val sharedPreferences=contex.getSharedPreferences("My Preferences",Context.MODE_PRIVATE)

    var username by remember{
        mutableStateOf(sharedPreferences.getString("username","Bulunamadı"))
    }
    Column {
        Text(text = "Kullanıcı Adı:$username")
        Button(onClick = {
            val editor=sharedPreferences.edit()
            editor.putString("username","Melek Yazıcı")
            editor.apply()
            username="Android Dersi"
        }) {
            Text(text ="Kullanıcı Adı Kaydet" )
            
        }
    }
}