package com.example.composebasics.ui.theme.mvvm.presentation

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
class NoteViewModel @Inject constructor(private val dao: NoteDao) : ViewModel() {
    private val _state: MutableStateFlow<List<Note>> = MutableStateFlow(listOf())
    val state = _state.asStateFlow()

    init {
        insetDummyData()
        getNotes()
    }

    private fun insetDummyData() {
        viewModelScope.launch {
            val list: MutableList<Note> = mutableListOf()
            for (i in 1..6) {
                list.add(Note(text = "Note Title #${i}"))
            }
            withContext(Dispatchers.IO) {
                dao.insertAll(list)
            }
        }
    }

    private fun getNotes() {
        viewModelScope.launch {
            dao.getAll().collectLatest {
                _state.emit(it)
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