package com.tugas.tubes2.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.FilmDetailBinding
import com.tugas.tubes2.presenter.DetailPresenter


class FilmDetailFragment : Fragment() {
    private lateinit var binding: FilmDetailBinding
    private lateinit var namaitem: TextView
    private lateinit var image : ImageView
    private lateinit var producerTxt: TextView
    private lateinit var episodeTxt: TextView
    private lateinit var directorTxt: TextView
    private lateinit var releaseDateTxt: TextView
    private lateinit var description: TextView
    private lateinit var listViewCharacters: RecyclerView
    private lateinit var listViewPlanets: RecyclerView
    private lateinit var listViewStarships: RecyclerView
    private lateinit var listViewVehicles: RecyclerView
    private lateinit var listViewSpecies: RecyclerView
    private lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FilmDetailBinding.inflate(inflater, container, false)
        namaitem = binding.namaItem
        image = binding.imageItem
        producerTxt = binding.producerTxt
        episodeTxt = binding.episodeTxt
        directorTxt = binding.directorTxt
        releaseDateTxt = binding.releaseDateTxt
        description = binding.description
        listViewCharacters = binding.listViewCharacters
        listViewPlanets = binding.listViewPlanets
        listViewStarships = binding.listViewStarShips
        listViewVehicles = binding.listViewVehicles
        listViewSpecies = binding.listViewSpecies


        val mainActivity = activity as MainActivity
        presenter = DetailPresenter()

        val bundle = this.arguments
        presenter.retriveDataFilms(bundle, mainActivity, this, image, namaitem, producerTxt, episodeTxt, directorTxt, releaseDateTxt, description, listViewCharacters, listViewPlanets, listViewSpecies, listViewVehicles, listViewStarships)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: android.view.MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list_back -> {
                activity?.supportFragmentManager?.popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)

        //referensi:
        //https://developer.android.com/guide/topics/ui/menus?hl=id
    }
}