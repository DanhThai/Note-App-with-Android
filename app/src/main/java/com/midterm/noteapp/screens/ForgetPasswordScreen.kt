package com.midterm.noteapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.midterm.noteapp.R
import com.midterm.noteapp.navigation.NoteScreens
import com.midterm.noteapp.ui.theme.PrimaryColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ForgetPasswordScreen(navController: NavController){
    val textStateEmailAddress = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedButton(onClick = { navController.popBackStack() },
                modifier= Modifier
                    .padding(0.dp, 15.dp, 0.dp, 0.dp)
                    .size(30.dp)
                    .align(Alignment.Start),
                shape = CircleShape,
                border= BorderStroke(1.dp, PrimaryColor),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor =  Color(android.graphics.Color.rgb(38, 198, 218))
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = "Back",
                    tint = PrimaryColor
                )
            }
            Spacer(modifier = Modifier.width(60.dp))

            Image(
                modifier = Modifier
                    .size(250.dp)
                    .padding(0.dp, 10.dp, 0.dp, 10.dp),
                painter = painterResource(id = R.drawable.image_login),
                contentDescription = "logo"
            )

            Text(
                text = "Quên mật khẩu",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(0.dp, 8.dp)
                    .align(Alignment.CenterHorizontally),
                color = PrimaryColor
            )

            OutlinedTextField(
                value = textStateEmailAddress.value,
                onValueChange = { textStateEmailAddress.value = it },
                label = {
                    Text(
                        "Địa chỉ email*",
                        color = if (textStateEmailAddress.value.isEmpty()) Color(android.graphics.Color.rgb(255, 121, 121)).copy(alpha = 0.5f)
                        else Color(android.graphics.Color.rgb(76, 175, 80))
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = if (textStateEmailAddress.value.isEmpty()) Color(
                        android.graphics.Color.rgb(
                            255,
                            121,
                            121
                        )
                    )
                    else Color(android.graphics.Color.rgb(76, 175, 80)),
                    unfocusedBorderColor = if (textStateEmailAddress.value.isEmpty()) PrimaryColor
                    else Color(android.graphics.Color.rgb(76, 175, 80))
                ),
                keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                singleLine = true,
                trailingIcon = {
                    if (textStateEmailAddress.value.isNotEmpty()) {
                        IconButton(onClick = { textStateEmailAddress.value = "" }) {
                            Icon(
                                imageVector = Icons.Outlined.Close,
                                contentDescription = null
                            )
                        }
                    }
                }
            )

            Button(
                onClick = {
                    navController.navigate(NoteScreens.LoginScreen.name)
                },
                shape = RoundedCornerShape(7.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 14.dp, 0.dp, 4.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PrimaryColor,
                    contentColor = Color.White
                ),
            ) {
                Text(
                    text = "Lấy mật khẩu", style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }
        }
    }

}