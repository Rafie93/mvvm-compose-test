package com.netwerk.salttest

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.netwerk.salttest.navigation.NavigationScreen
import com.netwerk.salttest.ui.theme.SaltTestTheme
import com.netwerk.salttest.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        setContent {
            SaltTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationScreen(viewModel = viewModel)
                }
            }
        }
    }
}