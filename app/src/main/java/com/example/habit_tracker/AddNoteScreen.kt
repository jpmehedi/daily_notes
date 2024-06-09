package com.example.habit_tracker
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
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

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.BackgroundColor
import com.example.habit_tracker.ui.theme.PrimaryColor
import com.example.habit_tracker.ui.theme.SecondaryColor
import com.example.habit_tracker.ui.theme.TextColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun AddNoteScreen() {
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
        topBar = { NoteScreenAppbar() },
        content = { innerPadding ->
            NoteScreenBody(innerPadding)
        },
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreenAppbar(){
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = SecondaryColor,
            titleContentColor = TextColor,
            navigationIconContentColor = TextColor,
            actionIconContentColor = TextColor
        ),
        title = { Text("Add Note") },
        navigationIcon = {
            IconButton(
                onClick = { /* Handle back button click */ }
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
fun NoteDropDownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit
){
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(
            text = {  Text("Refresh") },
            onClick = { /* Handle refresh! */ }
        )
        Divider()
        DropdownMenuItem(
            text = { Text("Settings") },
            onClick = { /* Handle settings! */ }
        )
        Divider()
        DropdownMenuItem(
            text = { Text("Send Feedback") },
            onClick = { /* Handle send feedback! */ }
        )
    }
}


@Composable
fun NoteScreenBody(innerPadding: PaddingValues){
    val title = remember { mutableStateOf("") }
    val content = remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .padding(innerPadding)
            .background(SecondaryColor)
    ){

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            value = title.value,
            onValueChange = { title.value = it },
            textStyle = TextStyle(fontSize = 24.sp, color = TextColor, fontWeight = FontWeight.Bold),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = SecondaryColor,
                unfocusedContainerColor = SecondaryColor,
            ),
            placeholder = {
                Text(
                    "Title",
                    style = TextStyle(fontSize = 24.sp, color = TextColor, fontWeight = FontWeight.Bold)
                )
            }

        )
        TextField(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            value = content.value,
            textStyle = TextStyle(fontSize = 18.sp, color = TextColor, fontWeight = FontWeight.Normal),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = SecondaryColor,
                unfocusedContainerColor = SecondaryColor,
            ),

            onValueChange = { content.value = it },
            placeholder = {
                Text(
                    "Type something...",
                    style = TextStyle(fontSize = 18.sp, color = TextColor, fontWeight = FontWeight.Normal)
                )
            }
        )
    }
}
