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
import com.bumptech.glide.Glide
import com.tugas.tubes2.APICall
import com.tugas.tubes2.BASE_IMAGE_URL
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.PeopleDetailBinding
import com.tugas.tubes2.databinding.PlanetDetailBinding


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

        val bundle = this.arguments
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")

            //glide
            Glide.with(this)
                .load("$BASE_IMAGE_URL/planets/$nomor.jpg")
                .into(image)

            APICall.getPlanetsDetail(mainActivity, "planets/$nomor") { planetDetail ->
                val planetDetailList = planetDetail.result
                namaitem.text = planetDetailList.properties.name
                diameter.text = "Diameter: " + planetDetailList.properties.diameter
                rotation.text = "Rotation: " +planetDetailList.properties.rotation_period
                orbital.text = "Orbital: " +planetDetailList.properties.orbital_period
                gravity.text = "Gravity: " +planetDetailList.properties.gravity
                population.text = "Population: " +planetDetailList.properties.population
                climate.text = "Climate: " +planetDetailList.properties.climate
                terrain.text = "Terrain: " +planetDetailList.properties.terrain
                surfaceWater.text = "SurfaceWater: " +planetDetailList.properties.surface_water
                description.text = "Description: " +planetDetailList.description

            }

        }else{
            namaitem.text = "Data tidak ditemukan"
        }
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