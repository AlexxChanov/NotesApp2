package com.example.notesapp.data

import com.example.notesapp.NotesApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
class NoteRepository {
    private val coroutineContext: CoroutineContext = Dispatchers.IO

    private val noteDao = NotesApplication.db.getNoteDao()
    private val categoryDao = NotesApplication.db.getCategoryDao()

    suspend fun createNewNote(title: String, text: String, price: Int, categoryId: Long) =
        withContext(coroutineContext) {
            noteDao.insertNote(Note(title, text, price, categoryId))

        }

    suspend fun getAllNotes() = withContext(coroutineContext) {
        noteDao.getAllNotes()
    }

    suspend fun deleteNote(note: Note) = withContext(coroutineContext) {
        noteDao.deleteNote(note)
    }

    suspend fun getAllCategories() = withContext(coroutineContext) {
        categoryDao.getAllCategories()
    }

    suspend fun createNewCategory(categoryName: String) = withContext(coroutineContext) {
        categoryDao.insertCategory(Category(categoryName))
    }

    suspend fun deleteCategory(category: Category) = withContext(coroutineContext) {
        categoryDao.deleteCategory(category)

    }

    suspend fun getCategoryWithNote() = withContext(coroutineContext) {
        categoryDao.getCategoriesWithNotes()
    }
}

