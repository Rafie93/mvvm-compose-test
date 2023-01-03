package com.netwerk.salttest.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.netwerk.salttest.data.response.UserList
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netwerk.salttest.ui.theme.Grey

@Composable
fun UserCard(
    userItem: UserList,
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(width = 1.dp, color = Grey),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable {

            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
//            AsyncImage(
//                model = userItem.avatar.toString(),
//                contentDescription = "Translated description of what the image contains" ,
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .fillMaxWidth()
//                    .height(80.dp)
//            )


            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = userItem.first_name,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = userItem.email,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(20.dp))



        }
    }
}

