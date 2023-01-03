package com.netwerk.salttest.ui.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.davidorellana.logincomposeretrofit2.ui.login.components.*
import com.netwerk.salttest.R
import com.netwerk.salttest.ui.components.TextError

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loadingProgressBar: Boolean,
    onclickLogin: (email: String, password: String) -> Unit,
    messageErrorAuth: String?
) {
    var email by rememberSaveable { mutableStateOf(value = "eve.holt@reqres.in") }
    var password by rememberSaveable { mutableStateOf(value = "") }
    val isValidate by derivedStateOf { email.isNotBlank() && password.isNotBlank() }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_image_login),
            contentDescription = "Image Login",
            modifier = modifier
                .fillMaxWidth()
                .size(300.dp),
            alignment = Alignment.Center
        )

        Spacer(modifier = modifier.height(65.dp))

        EmailOutTextField(
            textValue = email,
            onValueChange = { email = it },
            onClickButton = { email = "" },
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )
        if (!messageErrorAuth.equals("")){
            TextError(text = messageErrorAuth.toString())
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

        ButtonRound(
            onclick = { onclickLogin(email, password) },
            enabled = isValidate,
            text = "LOGIN"
        )


        Spacer(modifier = modifier.height(20.dp))
    }


    ProgressBarLoading(isLoading = loadingProgressBar)
}

