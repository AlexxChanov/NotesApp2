package com.example.notesapp.ui.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.data.Note
import kotlinx.android.synthetic.main.notes_list_item.view.*

class NotesAdapter(
    private val deleteNote: (Note) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NotesHolder>() {
    private val notes: MutableList<Note> = mutableListOf()

    fun addNotes(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_list_item, parent, false)
        return NotesHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NotesHolder, position: Int) {
        holder.bind(notes[position]) {
            deleteNote(it) // удаляем из базы данных
            notes.removeAt(position) // удаляем из списка ресайклера
            notifyItemRemoved(position) // инициируем перерисовку
            notifyItemRangeChanged(position, itemCount)//то же самое что и getItemCount
        }
    }

    class NotesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            note: Note,
            deleteNote: (Note) -> Unit
        ) = itemView.apply {
            notesTitle.text = note.title
            notesText.text = note.text
            notePrice.text = note.price.toString()

            buttonDeleteNote.setOnClickListener {
                deleteNote(note)

            }

        }

    }

}