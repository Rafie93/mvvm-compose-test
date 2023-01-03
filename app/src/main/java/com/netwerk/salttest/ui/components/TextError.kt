package com.netwerk.salttest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextError (
    text:String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        color = Color.Red,
        textAlign = TextAlign.Left,
        fontSize = 12.sp,
        modifier = modifier.fillMaxWidth().padding(start = 22.dp)
    )
}