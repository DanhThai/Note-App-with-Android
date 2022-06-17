package com.midterm.noteapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.midterm.noteapp.navigation.NoteScreens
import com.midterm.noteapp.ui.theme.PrimaryColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DetailScreen(navController: NavController){
    val textTitle = remember {
        mutableStateOf("Title")
    }

    val textContent = remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .width(50.dp)
                .height(35.dp)) {
                Text(text = "Hủy",
                    color = PrimaryColor,
                fontSize = 14.sp)
            }

            TextButton(onClick = {
                navController.navigate(NoteScreens.HomeScreen.name)
            },
                modifier = Modifier
                    .width(60.dp)
                    .height(35.dp)) {
                Text(text = "Xong",
                    color = PrimaryColor,
                fontSize = 14.sp)
            }
        }

        TextField(
            value = textTitle.value,
            onValueChange = {
                textTitle.value = it
            },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            maxLines = 1,
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            placeholder = { Text(text = "Title", color = Color.White.copy(alpha = 0.5f))},
            textStyle = TextStyle(fontWeight = FontWeight.Medium, color = Color.White,
                fontSize = 16.sp,
            letterSpacing = 2.sp),
        )



        TextField(
            value = textContent.value,
            onValueChange = {
                textContent.value = it
            },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            maxLines = 19,
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            placeholder = { Text(text = "Note here", color = Color.White.copy(alpha = 0.5f))},
            textStyle = TextStyle(fontWeight = FontWeight.Medium, color = Color.White,
                fontSize = 16.sp,
                letterSpacing = 2.sp),
        )
    }
}