package com.example.notesapp.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesapp.R
import com.example.notesapp.ui.categories.CategoriesListFragment
import com.example.notesapp.ui.notes.ListFragment
import kotlinx.android.synthetic.main.fragment_navigation.*

class NavFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        creatingFragmentBtn.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer,
                    CategoriesListFragment()
                )
                ?.addToBackStack(null)
                ?.commit()
        }

        notesListBtn.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer,
                    ListFragment()
                )
                ?.addToBackStack(null)
                ?.commit()
        }

    }

}