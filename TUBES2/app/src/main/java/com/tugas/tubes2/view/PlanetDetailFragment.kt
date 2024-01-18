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
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.PlanetDetailBinding
import com.tugas.tubes2.presenter.DetailPresenter


class PlanetDetailFragment : Fragment() {
    private lateinit var binding: PlanetDetailBinding
    private lateinit var namaitem: TextView
    private lateinit var image : ImageView
    private lateinit var diameter: TextView
    private lateinit var rotation: TextView
    private lateinit var orbital: TextView
    private lateinit var gravity: TextView
    private lateinit var population: TextView
    private lateinit var climate: TextView
    private lateinit var terrain: TextView
    private lateinit var surfaceWater: TextView
    private lateinit var description: TextView
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
        binding = PlanetDetailBinding.inflate(inflater, container, false)
        namaitem = binding.namaItem
        image = binding.imageItem
        diameter = binding.diameter
        rotation = binding.rotation
        orbital = binding.orbital
        gravity = binding.gravity
        population = binding.population
        climate = binding.climate
        terrain = binding.terrain
        surfaceWater = binding.surfaceWater
        description = binding.description

        val mainActivity = activity as MainActivity
        presenter = DetailPresenter()

        val bundle = this.arguments
        presenter.retriveDataPlanet(bundle, mainActivity, this, image, namaitem, diameter, rotation, orbital, gravity, population, climate, terrain, surfaceWater, description)
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