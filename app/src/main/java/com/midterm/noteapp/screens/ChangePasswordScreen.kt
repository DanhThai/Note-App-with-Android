package com.midterm.noteapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.midterm.noteapp.R
import com.midterm.noteapp.navigation.NoteScreens
import com.midterm.noteapp.ui.theme.PrimaryColor
import com.midterm.noteapp.ui.theme.PrimaryDarkColor

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun ChangePasswordScreen(navController: NavController){

    val textStateOldPassword = remember { mutableStateOf("") }
    val textStatePassword = remember { mutableStateOf("") }
    val textStatePasswordCallback = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        Modifier.padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = {
                navController.popBackStack()
            },
                modifier= Modifier
                    .size(30.dp),
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

            Text(text = "Đổi mật khẩu", fontSize = 24.sp, fontWeight = FontWeight.Medium,
                color = PrimaryColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
        }

        OutlinedTextField(
            value = textStateOldPassword.value,
            onValueChange = { textStateOldPassword.value = it },
            label = {
                Text(
                    "Mật khẩu cũ*",
                    color = if (textStateOldPassword.value.isEmpty()) Color(
                        android.graphics.Color.rgb(
                            255,
                            121,
                            121
                        )
                    ).copy(alpha = 0.5f)
                    else Color(android.graphics.Color.rgb(76, 175, 80))
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = if (textStateOldPassword.value.isEmpty()) Color(
                    android.graphics.Color.rgb(
                        255,
                        121,
                        121
                    )
                )
                else Color(android.graphics.Color.rgb(76, 175, 80)),
                unfocusedBorderColor = if(textStateOldPassword.value.isEmpty()) PrimaryDarkColor
                else PrimaryColor
            ),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(
                    Color.White, shape = RoundedCornerShape(5.dp),
                ),
            singleLine = true,
            trailingIcon = {
                if (textStateOldPassword.value.isNotEmpty()) {
                    IconButton(onClick = { textStateOldPassword.value = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )

        OutlinedTextField(
            value = textStatePassword.value,
            onValueChange = { textStatePassword.value = it },
            label = {
                Text(
                    "Mật khẩu",
                    color = if (textStatePassword.value.isEmpty()) Color(
                        android.graphics.Color.rgb(
                            255,
                            121,
                            121
                        )
                    ).copy(alpha = 0.5f)
                    else Color(android.graphics.Color.rgb(76, 175, 80))
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = if (textStatePassword.value.isEmpty()) Color(
                    android.graphics.Color.rgb(
                        255,
                        121,
                        121
                    )
                )
                else Color(android.graphics.Color.rgb(76, 175, 80)),
                unfocusedBorderColor = if(textStatePassword.value.isEmpty()) PrimaryDarkColor
                else PrimaryColor
            ),
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(
                    Color.White, shape = RoundedCornerShape(5.dp),
                ),
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            trailingIcon = {
                val image = if (passwordVisible.value)
                    R.drawable.ic_baseline_visibility_24
                else R.drawable.ic_baseline_visibility_off_24
                val description =
                    if (passwordVisible.value) "Hide password" else "Show password"

                IconButton(onClick = {
                    passwordVisible.value = !passwordVisible.value
                }) {
                    Icon(
                        painter = painterResource(id = image),
                        contentDescription = description,
                        tint = PrimaryColor
                    )
                }
            }
        )

        OutlinedTextField(
            value = textStatePasswordCallback.value,
            onValueChange = { textStatePasswordCallback.value = it },
            label = {
                Text(
                    "Nhập lại mật khẩu*",
                    color = if (textStatePasswordCallback.value.isEmpty()) Color(
                        android.graphics.Color.rgb(
                            255,
                            121,
                            121
                        )
                    ).copy(alpha = 0.5f)
                    else Color(android.graphics.Color.rgb(76, 175, 80))
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = if (textStatePasswordCallback.value.isEmpty()) Color(
                    android.graphics.Color.rgb(
                        255,
                        121,
                        121
                    )
                )
                else Color(android.graphics.Color.rgb(76, 175, 80)),
                unfocusedBorderColor = if(textStatePasswordCallback.value.isEmpty()) PrimaryDarkColor
                else PrimaryColor
            ),
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(
                    Color.White, shape = RoundedCornerShape(5.dp),
                ),
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            trailingIcon = {
                val image = if (passwordVisible.value)
                    R.drawable.ic_baseline_visibility_24
                else R.drawable.ic_baseline_visibility_off_24
                val description =
                    if (passwordVisible.value) "Hide password" else "Show password"

                IconButton(onClick = {
                    passwordVisible.value = !passwordVisible.value
                }) {
                    Icon(
                        painter = painterResource(id = image),
                        contentDescription = description,
                        tint = PrimaryColor
                    )
                }
            }
        )

        Button(onClick = {
            navController.navigate(NoteScreens.SettingScreen.name){
                popUpTo(NoteScreens.ChangePasswordScreen.name){
                    inclusive = true
                }
            }
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryDarkColor),
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Hoàn thành",
                    color = Color.White)
            }
        }
    }
}