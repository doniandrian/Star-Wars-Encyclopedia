package com.tugas.tubes2.view.presenterInterface

import android.widget.Button
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.tugas.tubes2.view.MainActivity

interface IMainFragment {
    interface Presenter {
        fun clickListener(activity: MainActivity, text_choosed: TextView, list_item: ListView, btn_films: Button, btn_people: Button, btn_planets: Button, btn_species: Button, btn_starships: Button, btn_vehicles: Button, position: Int)
        fun getAPIResult(activity: MainActivity, endpoint: String, list_item: ListView, progress_bar: ProgressBar)
        fun getAPIResult_Films(activity: MainActivity, endpoint: String, list_item: ListView, progress_bar: ProgressBar)
        fun onQueryTextChange(newText: String?, text_choosed: TextView, btn_films: Button, list_item: ListView)
    }
    interface Ui{
        fun changePage(fragment: Fragment)


    }
}