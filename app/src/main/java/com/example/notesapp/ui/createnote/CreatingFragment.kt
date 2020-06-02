package com.example.notesapp.ui.createnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.notesapp.R
import com.example.notesapp.data.Category
import com.example.notesapp.data.NoteRepository
import kotlinx.android.synthetic.main.fragment_notes_creating.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import kotlin.coroutines.CoroutineContext

class CreatingFragment : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    companion object {
        const val CATEGORY_KEY = "category"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes_creating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val category = arguments?.getParcelable<Category>(CATEGORY_KEY) ?: throw IllegalArgumentException("Category not found")
        val repo = NoteRepository()

        noteCreatingTitle.text = getString(R.string.note_category_title_template).format(category.name)

        createNew.setOnClickListener {
            val title = noteTitle.text.toString()
            val text = noteText.text.toString()
            val price = notePrice.text.toString().toIntOrNull()

            if (title.isNotBlank() && text.isNotBlank()&& price != null) {
                launch {
                    val id = repo.createNewNote(title, text, price,category.id)
                    Toast.makeText(context, "Inserted with id $id", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}