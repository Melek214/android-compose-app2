package com.example.jetpackegitim2.navigation

import NotesScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackegitim2.ui.noteadd.NoteAddScreen
import com.example.jetpackegitim2.ui.notesdetail.NoteDetailScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigatioItem.Note.route // uygulama ilk hangi sayfayla başlasın
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigatioItem.Note.route) {
            //notun üstüne basınca detay kısmını açmak icin composable
            NotesScreen(onClickDetail = { id ->
                navController.navigate("${NavigatioItem.NoteDetail.route}/$id")
            },
                // artı butonuna basınca not ekleme ekranına gider
                onClickAdd = {
                    navController.navigate((NavigatioItem.NoteAdd.route))
                })
        }
        //not kayıt ettikten sonra notlar sayfasına dönmek için
        composable(NavigatioItem.NoteAdd.route) {
            NoteAddScreen(
                navigateHome =  {
                    navController.navigate(NavigatioItem.Note.route)
                }
            )
        }
        // not detay ekranı id ile yönlendirme yapılır
        composable("${NavigatioItem.NoteDetail.route}/{id}") {
            val id = it.arguments?.getString("id")?.toIntOrNull() ?: -1
            NoteDetailScreen(id = id)
        }

    }
}