package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note): Long

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("select*from notes ")//* значит что нужно получить все поля
    suspend fun getAllNotes(): List<Note>

    @Query("select * from notes where id = :id")
    suspend fun getNoteById(id:Long): Note
}