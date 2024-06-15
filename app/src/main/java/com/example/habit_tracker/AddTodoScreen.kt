package com.example.habit_tracker
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.habit_tracker.ui.theme.BackgroundColor
import com.example.habit_tracker.ui.theme.PrimaryColor
import com.example.habit_tracker.ui.theme.SecondaryColor
import com.example.habit_tracker.ui.theme.TextColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun AddTodoScreen(navHostController: NavHostController) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val statusBarColor = SecondaryColor

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = useDarkIcons
        )
    }
    DisposableEffect(Unit) {
        onDispose {
            systemUiController.setStatusBarColor(
                color = BackgroundColor,
                darkIcons = useDarkIcons
            )
        }
    }
    Scaffold(
        modifier = Modifier.background(SecondaryColor),
        topBar = { TodoScreenAppbar(navHostController) },
        content = { innerPadding ->
            TodoScreenBody(innerPadding)
        },
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreenAppbar(navHostController: NavHostController){
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = SecondaryColor,
            titleContentColor = TextColor,
            navigationIconContentColor = TextColor,
            actionIconContentColor = TextColor
        ),
        title = { Text("Add Todo") },
        navigationIcon = {
            IconButton(
                onClick = {
                    navHostController.popBackStack()
                }
            )
            {
                Icon(Icons.Default.ArrowBack,  contentDescription = "Back", tint = PrimaryColor)
            }
        },
        actions = {
            IconButton(
                onClick = {
                    expanded = true
                }
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "More", tint = PrimaryColor)
                NoteDropDownMenu(expanded = expanded, onDismissRequest = { expanded = false })
            }
        }

    )
}

@Composable
fun   TodoScreenBody(
    innerPadding: PaddingValues
){


   var counter by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(innerPadding)
            .background(SecondaryColor),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
        
    ) {
        for (i in 1..counter) {
            Todos()
        }
        Button(
            onClick = {
                counter++
            },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = SecondaryColor, // Background color
                contentColor = PrimaryColor,  // Text color
            ),
            content = {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(SecondaryColor)
                ){
                    Icon(Icons.Default.Add,  contentDescription = "Back", tint = PrimaryColor, modifier = Modifier.size(36.dp))
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "Add Todo", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Normal, color = PrimaryColor))
                }
            }
        )

    }
}

@Composable
fun Todos(){
    var isChecked by remember { mutableStateOf(false) }
    val title = remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = title.value,

            onValueChange = { title.value = it },
            textStyle = TextStyle(fontSize = 18.sp, color = TextColor, fontWeight = FontWeight.Bold),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = SecondaryColor,
                unfocusedContainerColor = SecondaryColor,
            ),
            placeholder = {
                Text(
                    "Type something...",
                    style = TextStyle(fontSize = 18.sp, color = TextColor, fontWeight = FontWeight.Normal)
                )
            }

        )
    }
}
