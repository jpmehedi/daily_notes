package com.example.habit_tracker

enum class Screen {
    HOME,
    LOGIN,
    BASENAV,
    SIGNUP,
    PROFILE,
    HELP,
    OCR,
    SETTINGS,
    ADD_TODOLIST,
    ADD_NOTE,
    ONBOARDING
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object BaseNav : NavigationItem(Screen.BASENAV.name)
    data object Login : NavigationItem(Screen.LOGIN.name)
    data object Signup : NavigationItem(Screen.SIGNUP.name)
    data object Profile : NavigationItem(Screen.PROFILE.name)
    data object Help : NavigationItem(Screen.HELP.name)
    data object Ocr : NavigationItem(Screen.OCR.name)
    data object Settings : NavigationItem(Screen.SETTINGS.name)
    data object AddTodolist : NavigationItem(Screen.ADD_TODOLIST.name)
    data object AddNote : NavigationItem(Screen.ADD_NOTE.name)
    data object Onboarding : NavigationItem(Screen.ONBOARDING.name)
}