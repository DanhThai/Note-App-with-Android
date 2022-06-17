package com.midterm.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.midterm.noteapp.view.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NoteScreens.SplashScreen.name){
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

        composable(NoteScreens.DetailScreen.name ){
            DetailScreen(navController = navController)
        }

        composable(NoteScreens.SettingScreen.name ){
            SettingScreen(navController = navController)
        }

        composable(NoteScreens.ChangePasswordScreen.name ){
            ChangePasswordScreen(navController = navController)
        }
    }
}