package com.example.composebasics.app.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.composebasics.ui.theme.mvvm.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): Flow<List<Note>>

    @Query("SELECT * FROM note where id=:noteId")
    fun getNoteById(noteId: Int): Flow<Note>

    @Insert
    fun insertAll(notes: List<Note>)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)
}