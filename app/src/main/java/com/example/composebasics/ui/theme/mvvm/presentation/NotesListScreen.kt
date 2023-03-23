package com.example.composebasics.ui.theme.mvvm.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composebasics.ui.theme.mvvm.models.Note

@Composable
fun NotesListScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    navigateToNoteDetails: (Int) -> Unit
) {
    val notesList by viewModel.state.collectAsState()
    Column() {
        
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(notesList) { note ->
            NoteItem(note = note,
                     onNoteClicked = {
                         navigateToNoteDetails(note.id)
                     }, onFavoriteClicked = {
                    viewModel.changeNoteStatus(note)
                }, onDeleteClicked = {
                    viewModel.deleteNote(note)
                })
        }
    }
}

@Composable
fun NoteItem(
    note: Note,
    onNoteClicked: () -> Unit,
    onFavoriteClicked: () -> Unit,
    onDeleteClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onNoteClicked()
            }, shape = MaterialTheme.shapes.large
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = note.text, modifier = Modifier.padding(10.dp))
            Row {
                IconButton(onClick = { onFavoriteClicked() }) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "",
                        tint = if (note.isLiked) Color.Red else Color.Black
                    )
                }
                IconButton(onClick = { onDeleteClicked() }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "")
                }
            }
        }

    }
}