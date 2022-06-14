package com.midterm.noteapp.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.midterm.noteapp.navigation.NoteScreens
import com.midterm.noteapp.ui.theme.PrimaryColor
import com.midterm.noteapp.ui.theme.PrimaryDarkColor

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun HomeScreen(navController: NavController){
    val textSearch = remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    Scaffold(topBar = { } ,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //TODO ADD NOTE
                    navController.navigate(NoteScreens.DetailScreen.name)
                },
                modifier = Modifier
                    .size(38.dp),
                backgroundColor = PrimaryColor,
                shape = RoundedCornerShape(5.dp),
            ) {
                Icon(Icons.Filled.Add,"",
                tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
        , content = {
            Surface(
                modifier = Modifier
                    .padding(top = 25.dp, start = 10.dp, end = 10.dp, bottom = 0.dp)
                    .fillMaxSize()
            ) {
                Column() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(text = "Notes", fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = PrimaryColor)

                        Card(modifier = Modifier
                            .size(30.dp),
                        onClick = {
                            navController.navigate(NoteScreens.SettingScreen.name)
                        }){
                            Icon(imageVector = Icons.Outlined.Settings, contentDescription ="Setting",
                                tint = PrimaryColor,
                                modifier = Modifier.size(30.dp))
                        }
                    }

                    TextField(
                        value = textSearch.value,
                        onValueChange = {
                            textSearch.value = it
                        },
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .border(
                                BorderStroke(width = 1.dp, color = PrimaryDarkColor),
                                shape = RoundedCornerShape(8.dp)
                            )
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
                        placeholder = { Text(text = "Search here", color = Color.White.copy(alpha = 0.5f))},
                        textStyle = TextStyle(fontWeight = FontWeight.Light, color = Color.White,
                        fontSize = 16.sp),
                        trailingIcon = {
                            if (textSearch.value.isNotEmpty()) {
                                IconButton(onClick = { textSearch.value = "" }) {
                                    Icon(
                                        imageVector = Icons.Outlined.Close,
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    )

                    val listOfItem = remember {
                        mutableListOf(
                            "Hello ne",
                            "remaining width is distributed equally among the columns",
                            "have non-standard dimensions",
                            "Specify the column span with the",
                            "of the span scope’s values, is particularly usefu",
                            "Hello ne",
                            "remaining width is distributed equally among the columns",
                            "have non-standard dimensions",
                            "Specify the column span with the",
                            "of the span scope’s values, is particularly usefu",
                            "of the span scope’s values, is particularly usefu"
                        )
                    }

                    LazyVerticalGrid(
                        cells = GridCells.Adaptive(128.dp),
                    ) {
                        items(listOfItem.size) { item ->
                            NoteItem(listOfItem[item]){
                                navController.navigate(NoteScreens.DetailScreen.name)
                            }
                        }
                    }
                }
            }
        })
}

@Composable
fun NoteItem(title: String, onClick: ()-> Unit){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(160.dp)
            .height(180.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(PrimaryColor)
                    .padding(6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.width(110.dp)
                ) {
                    Text(text = title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White)
                    
                    Text(text = "26-05-2022 10:00 AM",
                        fontWeight = FontWeight.Light,
                        fontSize = 8.sp,
                        color = Color.White)
                }

                Icon(imageVector = Icons.Outlined.Delete, contentDescription = "Delete",
                tint = Color.White,
                modifier = Modifier.size(28.dp))
            }

            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Libero sagittis maecenas arcu just. Libero sagittis maecenas arcu just\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Libero sagittis maecenas arcu just. Libero sagittis maecenas arcu just Lorem ipsum dolor sit amet, consectetur adipiscing elit. Libero sagittis maecenas arcu just. Libero sagittis maecenas arcu just\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Libero sagittis maecenas arcu just. Libero sagittis maecenas arcu just\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Libero sagittis maecenas arcu just. Libero sagittis maecenas arcu just\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Libero sagittis maecenas arcu just. Libero sagittis maecenas arcu just",
                fontSize = 8.sp,
                fontWeight = FontWeight.Light,
                maxLines = 11,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black.copy(alpha = 0.6f),
                modifier = Modifier.padding(6.dp),
            lineHeight = 10.sp)

        }
    }
}