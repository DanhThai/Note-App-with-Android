package com.midterm.noteapp.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import android.graphics.Color.rgb
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.midterm.noteapp.R
import com.midterm.noteapp.navigation.NoteScreens
import com.midterm.noteapp.ui.theme.PrimaryColor
import com.midterm.noteapp.ui.theme.PrimaryDarkColor
import com.midterm.noteapp.ui.theme.PrimaryLightColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(scrollableState: ScrollState = rememberScrollState(),
          navController: NavController
){
    var textStateUserName = remember { mutableStateOf("") }
    var textStatePassword = remember { mutableStateOf("") }

    var passwordVisible  = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollableState),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .size(250.dp)
                    .padding(0.dp, 50.dp, 0.dp, 20.dp),
                painter = painterResource(id = R.drawable.image_login),
                contentDescription = "picture login")
            Text(
                text = "Đăng nhập",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(0.dp, 8.dp),
                color = PrimaryColor
            )

            Surface(
                color = PrimaryColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(464.dp),
                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
            ) {
                Column(verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 30.dp,
                horizontal = 40.dp)) {
                    OutlinedTextField(
                        value = textStateUserName.value,
                        onValueChange = {textStateUserName.value = it},
                        label = { Text("Tên đăng nhập", color = if(textStateUserName.value.isEmpty()) Color(rgb(255, 121, 121)).copy(alpha = 0.5f)
                        else Color(rgb(76, 175, 80))) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor =  if(textStateUserName.value.isEmpty()) Color(rgb(255, 121, 121))
                            else Color(rgb(76, 175, 80)),
                            unfocusedBorderColor = if(textStateUserName.value.isEmpty()) PrimaryDarkColor
                            else PrimaryColor)
                            ,
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
                            if (textStateUserName.value.isNotEmpty()) {
                                IconButton(onClick = { textStateUserName.value = "" }) {
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
                        onValueChange = {textStatePassword.value = it},
                        label = { Text("Mật khẩu", color = if(textStatePassword.value.isEmpty()) Color(rgb(255, 121, 121)).copy(alpha = 0.5f)
                        else Color(rgb(76, 175, 80))) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor =  if(textStatePassword.value.isEmpty()) Color(rgb(255, 121, 121))
                            else Color(rgb(76, 175, 80)),
                            unfocusedBorderColor = if(textStatePassword.value.isEmpty()) PrimaryDarkColor
                            else PrimaryColor ),
                        maxLines = 1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 8.dp)
                            .background(Color.White, shape = RoundedCornerShape(5.dp)),
                        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                        singleLine = true,
                        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
                        trailingIcon = {
                            val image = if (passwordVisible.value)
                                R.drawable.ic_baseline_visibility_24
                            else R.drawable.ic_baseline_visibility_off_24
                            val description = if (passwordVisible.value) "Hide password" else "Show password"

                            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}){
                                Icon(painter = painterResource(id = image), contentDescription = description
                                , tint = PrimaryColor)
                            }
                        }
                    )

                    TextButton(onClick = {
                        navController.navigate(NoteScreens.ForgetPasswordScreen.name)
                    },
                        modifier = Modifier.align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = PrimaryColor,
                            contentColor = Color(rgb(38, 198, 218))
                        ),
                        shape = RoundedCornerShape(50.dp)
                    ) {
                        Text(text = "Quên mật khẩu?", color = Color.White,
                        )
                    }

                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(onClick = {
                            navController.navigate(NoteScreens.SignupScreen.name)
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
                            Text(text = "Đăng ký", style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp
                            ))
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Button(onClick = {
                            navController.navigate(NoteScreens.HomeScreen.name){
                                popUpTo(NoteScreens.LoginScreen.name){
                                    inclusive = true
                                }
                            }
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