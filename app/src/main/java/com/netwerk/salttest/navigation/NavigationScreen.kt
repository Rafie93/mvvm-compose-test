package com.netwerk.salttest.navigation


import android.util.Log
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.netwerk.salttest.ui.home.Home
import com.netwerk.salttest.ui.login.LoginScreen
import com.netwerk.salttest.viewmodel.LoginViewModel


@Composable
fun NavigationScreen(viewModel: LoginViewModel) {
    val navController = rememberNavController()
    val imageError = viewModel.imageErrorAuth.value

    NavHost(
        navController = navController,
        startDestination = Destination.getStartDestination()
    ) {
        composable(route = Destination.Login.route) {
            if (viewModel.isSuccessLoading.value==true) {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(route = Destination.Home.route) {
                        popUpTo(route = Destination.Login.route) {
                            inclusive = true
                        }
                    }
                }
            }
            else {

                LoginScreen(
                    loadingProgressBar = viewModel.progressBar.value,
                    onclickLogin = viewModel::loginUser,
                    imageError = imageError,
                    messageErrorAuth = viewModel.messageErrorAuth.value,
                )
            }
        }

        composable(route = Destination.Home.route) {
            Home()
        }
    }
}