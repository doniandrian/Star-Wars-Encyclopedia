package com.tugas.tubes2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.tugas.tubes2.databinding.ActivityMainBinding
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var btn_films: Button
    private lateinit var btn_people: Button
    private lateinit var btn_planets: Button
    private lateinit var btn_species: Button
    private lateinit var btn_starships: Button
    private lateinit var btn_vehicles: Button
    private lateinit var text_choosed: TextView
    private lateinit var list_item: ListView

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

        list_item = binding.listItem

        text_choosed.text = btn_films.text

        btn_films.setOnClickListener {
//            text_choosed.text = btn_films.text
//
//            ApiCall.getResult(this, "films") { dataResult ->
//                val filmsList = dataResult.result
//
//
//                val adapter = ResultListAdapter(this, filmsList)
//                list_item.adapter = adapter
//            }
        }



        btn_people.setOnClickListener {
            text_choosed.text = btn_people.text

            ApiCall.getResult(this, "people?page=1&limit=83") { dataResult ->
                val peopleList = dataResult.results


                val adapter = ResultListAdapter(this, peopleList)
                list_item.adapter = adapter
            }
        }

        btn_planets.setOnClickListener {
            text_choosed.text = btn_planets.text

            ApiCall.getResult(this, "planets?page=1&limit=60") { dataResult ->
                val planetsList = dataResult.results

                val adapter = ResultListAdapter(this, planetsList)
                list_item.adapter = adapter
            }
        }

        btn_species.setOnClickListener {
            text_choosed.text = btn_species.text

            ApiCall.getResult(this, "species?page=1&limit=37") { dataResult ->
                val speciesList = dataResult.results

                val adapter = ResultListAdapter(this, speciesList)
                list_item.adapter = adapter
            }
        }

        btn_starships.setOnClickListener {
            text_choosed.text = btn_starships.text

            ApiCall.getResult(this, "starships?page=1&limit=36") { dataResult ->
                val starshipsList = dataResult.results

                val adapter = ResultListAdapter(this, starshipsList)
                list_item.adapter = adapter
            }
        }

        btn_vehicles.setOnClickListener {
            text_choosed.text = btn_vehicles.text

            ApiCall.getResult(this, "vehicles?page=1&limit=39") { dataResult ->
                val vehiclesList = dataResult.results

                val adapter = ResultListAdapter(this, vehiclesList)
                list_item.adapter = adapter
            }
        }
    }
}