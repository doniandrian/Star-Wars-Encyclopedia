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
import com.tugas.tubes2.databinding.FragmentMainBinding
import com.tugas.tubes2.model.DataResult
import com.tugas.tubes2.model.FilmsResult
import com.tugas.tubes2.presenter.MainPresenter

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
    private lateinit var mainPresenter: MainPresenter

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
        mainPresenter = MainPresenter()

        search_view.visibility = View.GONE

        btn_films.setOnClickListener {
            text_choosed.text = btn_films.text
            Log.d("MainFragment", "btn_films clicked")

            progress_bar.visibility = View.VISIBLE
            search_view.visibility = View.VISIBLE

            mainPresenter.getAPIResult_Films(mainActivity, "films", list_item, progress_bar)
        }

        btn_people.setOnClickListener {
            text_choosed.text = btn_people.text

            progress_bar.visibility = View.VISIBLE
            search_view.visibility = View.VISIBLE

            mainPresenter.getAPIResult(mainActivity, "people?page=1&limit=83", list_item, progress_bar)
        }

        btn_planets.setOnClickListener {
            text_choosed.text = btn_planets.text

            progress_bar.visibility = View.VISIBLE
            search_view.visibility = View.VISIBLE

            mainPresenter.getAPIResult(mainActivity, "planets?page=1&limit=60", list_item, progress_bar)
        }

        btn_species.setOnClickListener {
            text_choosed.text = btn_species.text

            progress_bar.visibility = View.VISIBLE
            search_view.visibility = View.VISIBLE

            mainPresenter.getAPIResult(mainActivity, "species?page=1&limit=37", list_item, progress_bar)
        }

        btn_starships.setOnClickListener {
            text_choosed.text = btn_starships.text

            progress_bar.visibility = View.VISIBLE
            search_view.visibility = View.VISIBLE

            mainPresenter.getAPIResult(mainActivity, "starships?page=1&limit=36", list_item, progress_bar)
        }

        btn_vehicles.setOnClickListener {
            text_choosed.text = btn_vehicles.text

            progress_bar.visibility = View.VISIBLE
            search_view.visibility = View.VISIBLE

            mainPresenter.getAPIResult(mainActivity, "vehicles?page=1&limit=39", list_item, progress_bar)
        }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                mainPresenter.onQueryTextChange(newText, text_choosed, btn_films, list_item)
                return true
            }
        })

        list_item.setOnItemClickListener { _, _, position, _ ->
            mainPresenter.clickListener(mainActivity, text_choosed, list_item, btn_films, btn_people, btn_planets, btn_species, btn_starships, btn_vehicles, position)
        }
        return binding.root
    }
}

// REFERENSI
// 1. https://www.geeksforgeeks.org/how-to-get-data-from-api-using-retrofit-library-in-android/ (Retrofit)
// 2. https://medium.com/@armanansari04.edugaon/how-to-create-searchview-with-listview-in-android-kotlin-d677a68291e4 (Search)