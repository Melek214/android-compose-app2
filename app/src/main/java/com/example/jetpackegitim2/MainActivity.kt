package com.example.jetpackegitim2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackegitim2.navigation.AppNavHost
import com.example.jetpackegitim2.navigation.NavigatioItem
import com.example.jetpackegitim2.ui.theme.JetPackEgitim2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackEgitim2Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        val backStackEntry = navController.currentBackStackEntryAsState().value
                        val showBackButton =
                            backStackEntry?.destination?.route != NavigatioItem.Note.route
                        MyTopBar(showBackButton, navController)
                    }) { innerPadding ->
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(showBackButton: Boolean, navController: NavHostController) {
    TopAppBar(title = { Text(text = "Not Uygulamam") },
        navigationIcon = {
            if (showBackButton) {
                Image(
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {
                            navController.popBackStack()
                        },
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null
                )
            }
        })
}

