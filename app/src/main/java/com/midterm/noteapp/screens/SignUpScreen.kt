package com.midterm.noteapp.screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.midterm.noteapp.R
import com.midterm.noteapp.navigation.NoteScreens
import com.midterm.noteapp.ui.theme.PrimaryColor
import com.midterm.noteapp.ui.theme.PrimaryDarkColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(navController: NavController){
    val textStateFullName = remember { mutableStateOf("") }
    val textStateEmailAddress = remember { mutableStateOf("") }
    val textStatePassword = remember { mutableStateOf("") }
    val textStatePasswordCallback = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .padding(0.dp, 10.dp, 0.dp, 10.dp),
                painter = painterResource(id = R.drawable.iconlogo),
                contentDescription = "logo"
            )

            Text(
                text = "Đăng ký",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(0.dp, 8.dp),
                color = PrimaryColor
            )

            Surface(
                color = PrimaryColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(594.dp),
                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
            ) {
                Column(verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = 30.dp,
                        horizontal = 40.dp)) {
                    OutlinedTextField(
                        value = textStateFullName.value,
                        onValueChange = { textStateFullName.value = it },
                        label = {
                            Text(
                                "Họ tên*",
                                color = if (textStateFullName.value.isEmpty()) Color(
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
                            focusedBorderColor = if (textStateFullName.value.isEmpty()) Color(
                                android.graphics.Color.rgb(
                                    255,
                                    121,
                                    121
                                )
                            )
                            else Color(android.graphics.Color.rgb(76, 175, 80)),
                            unfocusedBorderColor = if(textStateFullName.value.isEmpty()) PrimaryDarkColor
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
                            if (textStateFullName.value.isNotEmpty()) {
                                IconButton(onClick = { textStateFullName.value = "" }) {
                                    Icon(
                                        imageVector = Icons.Outlined.Close,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    )

                    OutlinedTextField(
                        value = textStateEmailAddress.value,
                        onValueChange = { textStateEmailAddress.value = it },
                        label = {
                            Text(
                                "Địa chỉ email*",
                                color = if (textStateEmailAddress.value.isEmpty()) Color(
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
                            focusedBorderColor = if (textStateEmailAddress.value.isEmpty()) Color(
                                android.graphics.Color.rgb(
                                    255,
                                    121,
                                    121
                                )
                            )
                            else Color(android.graphics.Color.rgb(76, 175, 80)),
                            unfocusedBorderColor = if(textStateEmailAddress.value.isEmpty()) PrimaryDarkColor
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

                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(onClick = {
                            navController.navigate(NoteScreens.LoginScreen.name)
                        },
                            shape = RoundedCornerShape(7.dp),
                            modifier = Modifier
                                .padding(0.dp, 14.dp, 0.dp, 4.dp)
                                .width(130.dp)
                                .height(47.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = PrimaryDarkColor,
                                contentColor = Color.White),
                        ){
                            Text(text = "Đăng ký", style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp
                            ))
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Button(onClick = {
                            navController.navigate(NoteScreens.LoginScreen.name)
                        },
                            shape = RoundedCornerShape(7.dp),
                            modifier = Modifier
                                .padding(0.dp, 14.dp, 0.dp, 4.dp)
                                .width(130.dp)
                                .height(47.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = PrimaryColor,
                                contentColor = Color.White),
                            border = BorderStroke(1.dp, color = PrimaryDarkColor)
                        ){
                            Text(text = "Đăng nhập", style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp
                            ))
                        }
                    }
                }
            }
        }
    }
}