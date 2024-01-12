package com.tugas.tubes2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.StarShipsDetailBinding


class StarShipsDetailFragment : Fragment() {
    private lateinit var binding: StarShipsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StarShipsDetailBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: android.view.MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list_back -> {
                val activity = requireActivity() as MainActivity
                activity.changePage(MainFragment())
            }
        }
        return super.onOptionsItemSelected(item)

        //referensi:
        //https://developer.android.com/guide/topics/ui/menus?hl=id
    }


}