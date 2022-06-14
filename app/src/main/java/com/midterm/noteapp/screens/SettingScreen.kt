package com.midterm.noteapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.midterm.noteapp.R
import com.midterm.noteapp.navigation.NoteScreens
import com.midterm.noteapp.ui.theme.PrimaryColor
import com.midterm.noteapp.ui.theme.PrimaryDarkColor

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingScreen(navController: NavController){
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

            Text(text = "Cài đặt", fontSize = 24.sp, fontWeight = FontWeight.Medium,
            color = PrimaryColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
        }

        Card(
            elevation = 10.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp,)
                .height(50.dp),
            shape = RoundedCornerShape(7.dp),
            onClick = {
                navController.navigate(NoteScreens.ChangePasswordScreen.name)
            }
        ) {
            Row(
                modifier  = Modifier.padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text ="Đổi mật khẩu",
                    color = PrimaryColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24), contentDescription = "",
                tint = PrimaryColor,
                modifier = Modifier.height(14.dp))
            }
        }

        Button(onClick = {
            navController.navigate(NoteScreens.LoginScreen.name){
                popUpTo(NoteScreens.SettingScreen.name){
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
                Icon(painter = painterResource(id = R.drawable.ic_baseline_exit_to_app_24), contentDescription = "log out",
                tint = Color.White)
                Text(text = "Đăng xuất",
                color = Color.White)
            }
        }
    }
}