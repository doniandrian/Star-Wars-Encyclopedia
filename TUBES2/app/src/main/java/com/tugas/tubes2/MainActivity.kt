package com.tugas.tubes2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.tugas.tubes2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var btn_films: Button
    private lateinit var btn_people: Button
    private lateinit var btn_planets: Button
    private lateinit var btn_species: Button
    private lateinit var btn_starships: Button
    private lateinit var btn_vehicles: Button
    private lateinit var text_choosed: TextView
    private lateinit var btn_previous: Button
    private lateinit var btn_next: Button
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
        btn_previous = binding.btnPrevious
        btn_next = binding.btnNext
        list_item = binding.listItem

        text_choosed.text = btn_films.text

        btn_films.setOnClickListener {
            text_choosed.text = btn_films.text
        }

        btn_people.setOnClickListener {
            text_choosed.text = btn_people.text
        }

        btn_planets.setOnClickListener {
            text_choosed.text = btn_planets.text
        }

        btn_species.setOnClickListener {
            text_choosed.text = btn_species.text
        }

        btn_starships.setOnClickListener {
            text_choosed.text = btn_starships.text
        }

        btn_vehicles.setOnClickListener {
            text_choosed.text = btn_vehicles.text
        }
    }
}