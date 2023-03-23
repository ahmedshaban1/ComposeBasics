package com.example.composebasics.ui.theme.mvvm.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composebasics.app.database.NoteDao
import com.example.composebasics.ui.theme.mvvm.models.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteDetailsViewModel @Inject constructor(
    private val dao: NoteDao,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state: MutableStateFlow<Note?> = MutableStateFlow(null)
    val state = _state.asStateFlow()
    private val noteId = savedStateHandle.get<String>("id")
    init {
        getNote(noteId)
    }

    private fun getNote(noteId: String?) {
        viewModelScope.launch {
            noteId?.let {
                dao.getNoteById(it.toInt()).collectLatest {note->
                    _state.emit(note)
                }
            }
        }

    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.delete(note)
            }
        }
    }

    fun changeNoteStatus(note: Note) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.update(note.copy(isLiked = !note.isLiked))
            }
        }
    }
}