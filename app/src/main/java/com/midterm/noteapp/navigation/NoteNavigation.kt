package com.midterm.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.midterm.noteapp.screens.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NoteScreens.ForgetPasswordScreen.name){
        composable(NoteScreens.SplashScreen.name ){
            NoteSplashScreen(navController = navController)
        }

        composable(NoteScreens.HomeScreen.name ){
            HomeScreen(navController = navController)
        }

        composable(NoteScreens.LoginScreen.name ){
            LoginScreen(navController = navController)
        }

        composable(NoteScreens.ForgetPasswordScreen.name ){
            ForgetPasswordScreen(navController = navController)
        }

        composable(NoteScreens.SignupScreen.name ){
            SignUpScreen(navController = navController)
        }
    }
}