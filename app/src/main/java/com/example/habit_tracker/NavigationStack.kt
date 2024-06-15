package com.example.habit_tracker

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavigationItem.Onboarding.route,
) {
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable(NavigationItem.Onboarding.route) {
          OnBoardingScreen(navController)
        }
        composable(NavigationItem.BaseNav.route) {
            BaseNavScreen(navController)
        }
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
/*        composable(NavigationItem.Login.route) {
            navController
        }*/
        composable(NavigationItem.Signup.route) {
            SignUpScreen(navController)
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
/*        composable(NavigationItem.Settings.route) {
           navController
        }*/

        composable(NavigationItem.Help.route) {
            HelpScreen()
        }
        composable(NavigationItem.Ocr.route) {
            OcrScreen()
        }

        composable(NavigationItem.AddNote.route) {
           AddNoteScreen(navController)
        }
        composable(NavigationItem.AddTodolist.route) {
            AddTodoScreen(
                navController
            )
        }


    }
}