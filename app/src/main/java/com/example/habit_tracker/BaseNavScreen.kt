package com.example.habit_tracker

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.ui.theme.BackgroundColor
import com.example.habit_tracker.ui.theme.PrimaryColor
import com.example.habit_tracker.ui.theme.SecondaryColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation")
@Preview(showBackground = true)
@Composable
fun BaseNavScreen(){
    val selectedItem = remember { mutableIntStateOf(0) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Surface {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Column {
                        Text(text = "Daily Notes")
                    }
                }
            },

        ) {
        Scaffold(
            topBar = {
                if (selectedItem.value == 0)
                    HomeTopAppBar(
                        onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    )
                if (selectedItem.value == 1)
                    OCRTopAppBar()
                if (selectedItem.value == 2)
                    HelpTopAppBar()
                if (selectedItem.value == 3)
                    ProfileTopAppBar()
            },
            content = { paddingValues ->
                Column (
                    modifier = Modifier
                        .padding(paddingValues)
                ){
                    if (selectedItem.value == 0)
                    HomeScreen()
                    if (selectedItem.value == 1)
                    OcrScreen()
                    if (selectedItem.value == 2)
                    HelpScreen()
                    if (selectedItem.value == 3)
                    ProfileScreen()
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    containerColor = PrimaryColor,
                    shape = CircleShape,
                    contentColor = SecondaryColor
                ) {
                    Icon(
                        modifier = Modifier,
                        imageVector = Icons.Default.Add,
                        contentDescription = " "
                    )
                }
            },
            bottomBar = {
             BottomNavigationBar(selectedItem)
            }
        )
        }

    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar( onClick: () -> Unit){

    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = onClick
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "")
            }
        },
        title = { Text("Notes") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BackgroundColor
        ),
        actions = {
            IconButton(
                onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.color_lens),
                    contentDescription = "Color lens"
                )
            }
            IconButton(
                onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.group),
                    contentDescription = "Group view"
                )
            }
        }

    )
}

@Composable
fun DrawerScreen(){
    ModalNavigationDrawer(
        drawerContent = {
            Text(text = "Hello")
        }
    ) {
       Text(text = "Hello")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OCRTopAppBar(){
    TopAppBar(
        title = { Text("OCR") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BackgroundColor
        ),
        actions = {
            IconButton(
                onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.content_copy),
                    contentDescription = "Color lens"
                )
            }

        }

    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpTopAppBar(){
    TopAppBar(
        title = { Text("Help") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BackgroundColor
        ),
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopAppBar(){
    TopAppBar(
        title = { Text("Profile") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BackgroundColor
        ),

    )
}
@Composable
fun BottomNavigationBar(
    selectedItem: MutableState<Int>,
){
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.OCR,
        BottomNavItem.Help,
        BottomNavItem.Profile
    )



    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(modifier = Modifier.size(24.dp), painter = painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index }
            )
        }
    }
}

sealed class BottomNavItem(val route: String, val icon: Int, val title: String) {
    data object Home : BottomNavItem("home", R.drawable.sticky_note, "Home")
    data object OCR : BottomNavItem("ocr", R.drawable.image_search, "OCR")
    data object Help : BottomNavItem("ocr", R.drawable.help, "Help")
    data object Profile : BottomNavItem("profile", R.drawable.person, "Profile")
}

