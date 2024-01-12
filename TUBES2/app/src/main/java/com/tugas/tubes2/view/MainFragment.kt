package com.tugas.tubes2.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import com.tugas.tubes2.APICall
import com.tugas.tubes2.APICall_Films
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.FragmentMainBinding
import com.tugas.tubes2.model.DataResult
import com.tugas.tubes2.model.FilmsResult

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var btn_films: Button
    private lateinit var btn_people: Button
    private lateinit var btn_planets: Button
    private lateinit var btn_species: Button
    private lateinit var btn_starships: Button
    private lateinit var btn_vehicles: Button
    private lateinit var text_choosed: TextView
    private lateinit var search_view: SearchView
    private lateinit var list_item: ListView
    private lateinit var progress_bar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        btn_films = binding.btnFilms
        btn_people = binding.btnPeople
        btn_planets = binding.btnPlanets
        btn_species = binding.btnSpecies
        btn_starships = binding.btnStarships
        btn_vehicles = binding.btnVehicles
        text_choosed = binding.textBtnChoosed
        search_view = binding.searchView
        list_item = binding.listItem
        progress_bar = binding.loading
        var mainActivity = activity as MainActivity

        btn_films.setOnClickListener {
            text_choosed.text = btn_films.text
            Log.d("MainFragment", "btn_films clicked")

            progress_bar.visibility = View.VISIBLE

            APICall_Films.getFilmResult(mainActivity, "films") { filmResult ->
                val filmsList = filmResult.result

                val adapter = FilmsListAdapter(mainActivity, filmsList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_people.setOnClickListener {
            text_choosed.text = btn_people.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(mainActivity, "people?page=1&limit=83") { dataResult ->
                val peopleList = dataResult.results

                val adapter = ResultListAdapter(mainActivity, peopleList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_planets.setOnClickListener {
            text_choosed.text = btn_planets.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(mainActivity, "planets?page=1&limit=60") { dataResult ->
                val planetsList = dataResult.results

                val adapter = ResultListAdapter(mainActivity, planetsList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_species.setOnClickListener {
            text_choosed.text = btn_species.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(mainActivity, "species?page=1&limit=37") { dataResult ->
                val speciesList = dataResult.results

                val adapter = ResultListAdapter(mainActivity, speciesList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_starships.setOnClickListener {
            text_choosed.text = btn_starships.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(mainActivity, "starships?page=1&limit=36") { dataResult ->
                val starshipsList = dataResult.results

                val adapter = ResultListAdapter(mainActivity, starshipsList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_vehicles.setOnClickListener {
            text_choosed.text = btn_vehicles.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(mainActivity, "vehicles?page=1&limit=39") { dataResult ->
                val vehiclesList = dataResult.results

                val adapter = ResultListAdapter(mainActivity, vehiclesList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                if (text_choosed.text == btn_films.text) {
                    (list_item.adapter as FilmsListAdapter).filter.filter(newText)
                }
                else {
                    (list_item.adapter as ResultListAdapter).filter.filter(newText)
                }
                return true
            }
        })

        list_item.setOnItemClickListener { _, _, position, _ ->
            //check if the item is a people, planets, species, starships, films or vehicles
            if (text_choosed.text == btn_films.text) {
                val selectedItem = list_item.adapter.getItem(position) as FilmsResult.Film.Properties
                val bundle = Bundle().apply {
                    putString("url", selectedItem.url)
                }

                val detailFragment = FilmDetailFragment()
                detailFragment.arguments = bundle
                mainActivity.changePage(detailFragment)
            }
            else if (text_choosed.text == btn_people.text) {
                val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
                val bundle = Bundle().apply {
                    putString("url", selectedItem.url)
                }

                val detailFragment = PeopleDetailFragment()
                detailFragment.arguments = bundle
                mainActivity.changePage(detailFragment)
            }else if (text_choosed.text == btn_planets.text) {
                val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
                val bundle = Bundle().apply {
                    putString("url", selectedItem.url)
                }

                val detailFragment = PlanetDetailFragment()
                detailFragment.arguments = bundle
                mainActivity.changePage(detailFragment)
            }else if (text_choosed.text == btn_species.text) {
                val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
                val bundle = Bundle().apply {
                    putString("url", selectedItem.url)
                }

                val detailFragment = SpeciesDetailFragment()
                detailFragment.arguments = bundle
                mainActivity.changePage(detailFragment)
            }else if (text_choosed.text == btn_starships.text) {
                val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
                val bundle = Bundle().apply {
                    putString("url", selectedItem.url)
                }

                val detailFragment = StarShipsDetailFragment()
                detailFragment.arguments = bundle
                mainActivity.changePage(detailFragment)
            }else if (text_choosed.text == btn_vehicles.text) {
                val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
                val bundle = Bundle().apply {
                    putString("url", selectedItem.url)
                }

                val detailFragment = VehiclesDetailFragment()
                detailFragment.arguments = bundle
                mainActivity.changePage(detailFragment)

            }


        }

        return binding.root
    }


}