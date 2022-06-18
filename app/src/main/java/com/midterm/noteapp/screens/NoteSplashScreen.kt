package com.midterm.noteapp.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.midterm.noteapp.R
import com.midterm.noteapp.navigation.NoteScreens
import kotlinx.coroutines.delay

@Composable
fun NoteSplashScreen(navController: NavHostController){
    val startAnimation = remember {
        mutableStateOf( false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation.value) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1  = true) {
        startAnimation.value = true
        delay( 2000)
        navController.popBackStack()
        navController.navigate(NoteScreens.LoginScreen.name)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .alpha(alpha = alpha),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.iconlogo),
            modifier = Modifier.size(150.dp),
            contentDescription = "Logo Icon",////
        )
    }
}
