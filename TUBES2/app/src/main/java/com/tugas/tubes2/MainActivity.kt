package com.tugas.tubes2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.tugas.tubes2.databinding.ActivityMainBinding
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_films = binding.btnFilms
        btn_people = binding.btnPeople
        btn_planets = binding.btnPlanets
        btn_species = binding.btnSpecies
        btn_starships = binding.btnStarships
        btn_vehicles = binding.btnVehicles
        text_choosed = binding.textBtnChoosed
        text_choosed.text = btn_films.text
        search_view = binding.searchView
        list_item = binding.listItem
        progress_bar = binding.loading

        btn_films.setOnClickListener {
            text_choosed.text = btn_films.text

            progress_bar.visibility = View.VISIBLE

            APICall_Films.getFilmResult(this, "films") { filmResult ->
                val filmsList = filmResult.result

                val adapter = FilmsListAdapter(this, filmsList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_people.setOnClickListener {
            text_choosed.text = btn_people.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(this, "people?page=1&limit=83") { dataResult ->
                val peopleList = dataResult.results

                val adapter = ResultListAdapter(this, peopleList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_planets.setOnClickListener {
            text_choosed.text = btn_planets.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(this, "planets?page=1&limit=60") { dataResult ->
                val planetsList = dataResult.results

                val adapter = ResultListAdapter(this, planetsList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_species.setOnClickListener {
            text_choosed.text = btn_species.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(this, "species?page=1&limit=37") { dataResult ->
                val speciesList = dataResult.results

                val adapter = ResultListAdapter(this, speciesList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_starships.setOnClickListener {
            text_choosed.text = btn_starships.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(this, "starships?page=1&limit=36") { dataResult ->
                val starshipsList = dataResult.results

                val adapter = ResultListAdapter(this, starshipsList)
                list_item.adapter = adapter

                progress_bar.visibility = View.GONE
            }
        }

        btn_vehicles.setOnClickListener {
            text_choosed.text = btn_vehicles.text

            progress_bar.visibility = View.VISIBLE

            APICall.getResult(this, "vehicles?page=1&limit=39") { dataResult ->
                val vehiclesList = dataResult.results

                val adapter = ResultListAdapter(this, vehiclesList)
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
    }
}