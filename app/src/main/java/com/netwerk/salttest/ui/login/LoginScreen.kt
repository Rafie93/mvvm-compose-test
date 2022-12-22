package com.netwerk.salttest.ui.login


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.davidorellana.logincomposeretrofit2.ui.login.components.*

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loadingProgressBar: Boolean,
    onclickLogin: (email: String, password: String) -> Unit,
    imageError: Boolean,
    messageErrorAuth: String?
) {
    var email by rememberSaveable { mutableStateOf(value = "") }
    var password by rememberSaveable { mutableStateOf(value = "") }
    val isValidate by derivedStateOf { email.isNotBlank() && password.isNotBlank() }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageLogin()

        TextLogin()

        Spacer(modifier = modifier.height(15.dp))

        EmailOutTextField(
            textValue = email,
            onValueChange = { email = it },
            onClickButton = { email = "" },
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )
        if (!messageErrorAuth.equals("")){
            Text(text = messageErrorAuth.toString())
            Spacer(modifier = modifier.height(10.dp))
        }

        Spacer(modifier = modifier.height(15.dp))

        PasswordOutTextField(
            textValue = password,
            onValueChange = { password = it },
            onDone = {
                focusManager.clearFocus()
            }
        )

        Spacer(modifier = modifier.height(35.dp))

        ButtonLogin(
            onclick = { onclickLogin(email, password) },
            enabled = isValidate
        )


        Spacer(modifier = modifier.height(20.dp))
    }

    ErrorImageAuth(isImageValidate = imageError)

    ProgressBarLoading(isLoading = loadingProgressBar)
}

