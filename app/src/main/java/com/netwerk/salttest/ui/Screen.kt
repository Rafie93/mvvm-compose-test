package com.netwerk.salttest.ui


sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object BottomBar : Screen("bottom_bar")
    object AppScaffold : Screen("app_scaffold")

}