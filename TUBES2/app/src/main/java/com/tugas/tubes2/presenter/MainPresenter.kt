package com.tugas.tubes2.presenter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import com.tugas.tubes2.APICall
import com.tugas.tubes2.model.DataResult
import com.tugas.tubes2.model.FilmsResult
import com.tugas.tubes2.view.FilmDetailFragment
import com.tugas.tubes2.view.adapter.FilmsListAdapter
import com.tugas.tubes2.view.presenterInterface.IMainFragment
import com.tugas.tubes2.view.MainActivity
import com.tugas.tubes2.view.PeopleDetailFragment
import com.tugas.tubes2.view.PlanetDetailFragment
import com.tugas.tubes2.view.adapter.ResultListAdapter
import com.tugas.tubes2.view.SpeciesDetailFragment
import com.tugas.tubes2.view.StarShipsDetailFragment
import com.tugas.tubes2.view.VehiclesDetailFragment

class MainPresenter : IMainFragment.Presenter {
    override fun clickListener(activity: MainActivity, text_choosed: TextView, list_item: ListView, btn_films: Button, btn_people: Button, btn_planets: Button, btn_species: Button, btn_starships: Button, btn_vehicles: Button, position: Int) {
        if (text_choosed.text == btn_films.text) {
            val selectedItem = list_item.adapter.getItem(position) as FilmsResult.Film
            val bundle = Bundle().apply {
                putString("url", selectedItem.properties.url)
            }

            val detailFragment = FilmDetailFragment()
            detailFragment.arguments = bundle
            activity.changePage(detailFragment)
        }
        else if (text_choosed.text == btn_people.text) {
            val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
            val bundle = Bundle().apply {
                putString("url", selectedItem.url)
            }

            val detailFragment = PeopleDetailFragment()
            detailFragment.arguments = bundle
            activity.changePage(detailFragment)
        }
        else if (text_choosed.text == btn_planets.text) {
            val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
            val bundle = Bundle().apply {
                putString("url", selectedItem.url)
            }

            val detailFragment = PlanetDetailFragment()
            detailFragment.arguments = bundle
            activity.changePage(detailFragment)
        }
        else if (text_choosed.text == btn_species.text) {
            val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
            val bundle = Bundle().apply {
                putString("url", selectedItem.url)
            }

            val detailFragment = SpeciesDetailFragment()
            detailFragment.arguments = bundle
            activity.changePage(detailFragment)
        }
        else if (text_choosed.text == btn_starships.text) {
            val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
            val bundle = Bundle().apply {
                putString("url", selectedItem.url)
            }

            val detailFragment = StarShipsDetailFragment()
            detailFragment.arguments = bundle
            activity.changePage(detailFragment)
        }
        else if (text_choosed.text == btn_vehicles.text) {
            val selectedItem = list_item.adapter.getItem(position) as DataResult.Result
            val bundle = Bundle().apply {
                putString("url", selectedItem.url)
            }

            val detailFragment = VehiclesDetailFragment()
            detailFragment.arguments = bundle
            activity.changePage(detailFragment)
        }
    }

    override fun getAPIResult(activity: MainActivity, endpoint: String, list_item: ListView, progress_bar: ProgressBar) {
        APICall.getResult(activity, endpoint) { dataResult ->
            val resultList = dataResult.results

            val adapter = ResultListAdapter(activity, resultList, presenter = MainAdapterPresenter())
            list_item.adapter = adapter

            progress_bar.visibility = View.GONE
        }
    }

    override fun getAPIResult_Films(activity: MainActivity,  endpoint: String,  list_item: ListView,  progress_bar: ProgressBar) {
        APICall.getFilmResult(activity, "films") { filmResult ->
            val filmsList = filmResult.result

            val adapter = FilmsListAdapter(activity, filmsList, presenter = MainAdapterPresenter())
            list_item.adapter = adapter

            progress_bar.visibility = View.GONE
        }
    }

    override fun onQueryTextChange(newText: String?, text_choosed: TextView, btn_films: Button, list_item: ListView) {
        if (text_choosed.text == btn_films.text) {
            (list_item.adapter as FilmsListAdapter).filter.filter(newText)
        }
        else {
            (list_item.adapter as ResultListAdapter).filter.filter(newText)
        }
    }

}