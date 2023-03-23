package com.example.composebasics.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composebasics.ui.theme.mvvm.models.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}


