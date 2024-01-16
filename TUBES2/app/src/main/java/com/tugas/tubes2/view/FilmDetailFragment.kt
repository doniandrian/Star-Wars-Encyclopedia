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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tugas.tubes2.APICall
import com.tugas.tubes2.BASE_IMAGE_URL
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.FilmDetailBinding
import com.tugas.tubes2.databinding.PeopleDetailBinding


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

        val bundle = this.arguments
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")
            //glide
            Glide.with(this)
                .load("$BASE_IMAGE_URL/films/$nomor.jpg")
                .error(R.drawable.picture_error_icon)
                .into(image)

            APICall.getFilmsDetail(mainActivity, "films/$nomor") { filmsDetail ->
                val FilmsDetail = filmsDetail.result
                namaitem.text = FilmsDetail.properties.title
                producerTxt.text = "Producer: " + FilmsDetail.properties.producer
                episodeTxt.text = "Episode: " + FilmsDetail.properties.episode_id.toString()
                directorTxt.text = "Director: " + FilmsDetail.properties.director
                releaseDateTxt.text = "Release Date: " + FilmsDetail.properties.release_date
                description.text ="Description: " + FilmsDetail.description

                //recycler view people
                val peopleDetailAdapter = PeopleDetailAdapter(FilmsDetail.properties.characters)
                listViewCharacters.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    peopleDetailAdapter.notifyDataSetChanged()
                    adapter = peopleDetailAdapter
                }

                //recycler view planets
                val planetsDetailAdapter = PlanetsDetailAdapter(FilmsDetail.properties.planets)
                listViewPlanets.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    planetsDetailAdapter.notifyDataSetChanged()
                    adapter = planetsDetailAdapter
                }

                //recycler view starships
                val starshipsDetailAdapter = StarshipsDetailAdapter(FilmsDetail.properties.starships)
                listViewStarships.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    starshipsDetailAdapter.notifyDataSetChanged()
                    adapter = starshipsDetailAdapter
                }

                //recycler view vehicles
                val vehiclesDetailAdapter = VehiclesDetailAdapter(FilmsDetail.properties.vehicles)
                listViewVehicles.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    vehiclesDetailAdapter.notifyDataSetChanged()
                    adapter = vehiclesDetailAdapter
                }

                //recycler view species
                val speciesDetailAdapter = SpeciesDetailAdapter(FilmsDetail.properties.species)
                listViewSpecies.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    speciesDetailAdapter.notifyDataSetChanged()
                    adapter = speciesDetailAdapter
                }



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