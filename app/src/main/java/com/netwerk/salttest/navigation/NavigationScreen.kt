package com.netwerk.salttest.navigation


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.netwerk.salttest.ui.home.Home
import com.netwerk.salttest.ui.login.LoginScreen
import com.netwerk.salttest.viewmodel.HomeViewModel
import com.netwerk.salttest.viewmodel.LoginViewModel


@Composable
fun NavigationScreen(loginViewModel: LoginViewModel,homeViewModel: HomeViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.getStartDestination()
    ) {
        composable(route = Destination.Login.route) {
            val mContext = LocalContext.current

            if (loginViewModel.isSuccessLoading.value==true) {
                Toast.makeText(mContext,"Anda Berhasil Login",Toast.LENGTH_SHORT).show()
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
                    loadingProgressBar = loginViewModel.progressBar.value,
                    onclickLogin = loginViewModel::loginUser,
                    messageErrorAuth = loginViewModel.messageErrorAuth.value,
                )
            }
        }

        composable(route = Destination.Home.route) {
            Home(homeViewModel)
        }
    }


}