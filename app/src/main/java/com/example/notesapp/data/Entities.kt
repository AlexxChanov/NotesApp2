package com.example.notesapp.data

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "notes")
data class Note(
    val title: String,
    val text: String,
    val price: Int,
    val categoryId: Long,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)

@Parcelize
@Entity(tableName = "categories")
data class Category(
    val name: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
) : Parcelable

data class CategotyWithNotes(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "id",
        entityColumn = "categoryId"
    )
    val notes: List<Note>
)
