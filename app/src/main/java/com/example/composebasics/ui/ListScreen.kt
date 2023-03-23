package com.example.composebasics.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

@Composable
fun ListScreen() {
    var state by remember {
        mutableStateOf(1)
    }
    Scaffold(Modifier.fillMaxSize(),
             topBar = { BuildTopBar() },
             floatingActionButton = {
                 FloatingActionButton(onClick = {
                     state = ++state
                 }) {
                     Icon(imageVector = Icons.Default.Add, contentDescription = "")
                 }
             }) { padding ->

        Column(Modifier.fillMaxSize()) {
            Text(text = state.toString() , style = MaterialTheme.typography.h3)
            ListLazyColumnContent(padding)
        }


    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ComposeBasicsTheme {
        ListScreen()
    }
}

@Composable
fun BuildTopBar() {
    TopAppBar(title = { Text(text = "List title") }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = ""
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = ""
            )
        }
    }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = ""
            )
        }
    })
}

@Composable
fun ListColumnContent(padding: PaddingValues) {
    Column(Modifier.padding(padding)) {
        for (i in 0..100) {
            Text(text = "Item $i", modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun ListLazyColumnContent(padding: PaddingValues) {
    LazyColumn(
        Modifier
            .padding(padding)
            .fillMaxSize()) {

        item { ListLazyRowContent(padding) }
        items(100){value->
            Text(text = "Item $value", modifier = Modifier
                .padding(10.dp)
                .clickable {
                    Log.d("ListLazyColumnContent", "click fired")
                })
        }

    }
}

@Composable
fun ListLazyRowContent(padding: PaddingValues) {
    LazyRow(
        Modifier
            .padding(padding)
            .fillMaxSize()) {
        items(20){value->
            Text(text = "Item $value", modifier = Modifier.padding(10.dp))
        }
    }
}