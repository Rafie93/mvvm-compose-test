package com.davidorellana.logincomposeretrofit2.ui.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netwerk.salttest.ui.theme.Primary

@Composable
fun ButtonRound(
    text:String,
    onclick: () -> Unit,
    enabled: Boolean
) {
    Button(
        onClick = onclick,
        enabled = enabled,
        shape = CircleShape,
        elevation = ButtonDefaults.elevation(defaultElevation = 12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Primary
        )
    ) {
        Text(text = text,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(5.dp)
        )
    }
}