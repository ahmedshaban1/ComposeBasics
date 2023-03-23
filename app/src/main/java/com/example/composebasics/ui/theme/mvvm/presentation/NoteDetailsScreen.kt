package com.example.composebasics.ui.theme.mvvm.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoteDetailsScreen(viewModel: NoteDetailsViewModel = hiltViewModel(), navigateUp: () -> Unit) {
    val note by viewModel.state.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.Center
    ) {
        note?.let {
            NoteItem(note = it, onNoteClicked = { }, onFavoriteClicked = {
                viewModel.changeNoteStatus(it)
            }) {
                viewModel.deleteNote(it)
                navigateUp()
            }
        }
    }
}