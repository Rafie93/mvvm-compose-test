package com.netwerk.salttest.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.netwerk.salttest.data.response.UserList
import androidx.compose.runtime.*
import com.netwerk.salttest.viewmodel.HomeViewModel


@Composable
fun Home(
    homeViewModel: HomeViewModel
) {
    Scaffold(

    ) {
        homeViewModel.getUser()
        MovieList(movieList = homeViewModel.userListResponse)
    }
}


@Composable
fun MovieList(movieList: List<UserList>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(items = movieList) { index, item ->
            UserItem(user = item, index, selectedIndex) { i ->
                selectedIndex = i
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun UserItem() {
    val user = UserList(
        1,
        "Coco",
        "Coco is a 2017 American 3D computer-animated musical fantasy adventure film produced by Pixar",
        "Latest",
        "https://howtodoandroid.com/images/coco.jpg",
        )

    UserItem(user = user, 0, 0) { i ->

    }
}


@Composable
fun UserItem(user: UserList, index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {

    val backgroundColor =
        if (index == selectedIndex) MaterialTheme.colors.primary else MaterialTheme.colors.background
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .clickable { onClick(index) }
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface(color = backgroundColor) {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

//                AsyncImage(
//                    model = user.avatar.toString(),
//                    contentDescription = "Translated description of what the image contains" ,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(80.dp)
//                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = user.first_name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = user.last_name,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = user.email,
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }

}