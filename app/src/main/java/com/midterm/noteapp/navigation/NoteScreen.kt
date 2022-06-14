package com.midterm.noteapp.navigation

enum class NoteScreens {
    SplashScreen,
    LoginScreen,
    SignupScreen,
    HomeScreen,
    ForgetPasswordScreen,
    DetailScreen,
    SettingScreen,
    ChangePasswordScreen;

    companion object {
        fun noteRoute(route: String?):NoteScreens
                =
            when(route?.substringBefore("/")){
                SplashScreen.name -> SplashScreen
                LoginScreen.name -> LoginScreen
                SignupScreen.name -> SignupScreen
                HomeScreen.name -> HomeScreen
                ForgetPasswordScreen.name -> ForgetPasswordScreen
                DetailScreen.name -> DetailScreen
                SettingScreen.name -> SettingScreen
                ChangePasswordScreen.name -> ChangePasswordScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}