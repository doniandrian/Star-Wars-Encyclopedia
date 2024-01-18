package com.tugas.tubes2.view.presenterInterface

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tugas.tubes2.view.FilmDetailFragment
import com.tugas.tubes2.view.MainActivity
import com.tugas.tubes2.view.PeopleDetailFragment
import com.tugas.tubes2.view.PlanetDetailFragment
import com.tugas.tubes2.view.SpeciesDetailFragment
import com.tugas.tubes2.view.StarShipsDetailFragment
import com.tugas.tubes2.view.VehiclesDetailFragment

interface IDetailFragment {
    interface Presenter {
        fun retriveDataFilms(bundle: Bundle?, activity: MainActivity, fragment: FilmDetailFragment, image: ImageView, namaitem: TextView,
                        producerTxt: TextView, episodeTxt: TextView, directorTxt: TextView, releaseDateTxt: TextView, description: TextView,
                        listViewCharacters: RecyclerView, listViewPlanets: RecyclerView, listViewSpecies: RecyclerView, listViewVehicles: RecyclerView,
                        listViewStarships: RecyclerView)

        fun retriveDataPeople(bundle: Bundle?, image: ImageView, activity: MainActivity, fragment: PeopleDetailFragment, namaitem: TextView, height: TextView,
                        mass: TextView, haircolor: TextView, skincolor: TextView, eyecolor: TextView, birthyear: TextView, gender: TextView,
                        homeworld: TextView, description: TextView)

        fun retriveDataPlanet(bundle: Bundle?, activity: MainActivity, fragment: PlanetDetailFragment, image: ImageView, namaitem: TextView,
                        diameter: TextView, rotation: TextView, orbital: TextView, gravity: TextView, population: TextView,
                        climate: TextView, terrain: TextView, surfaceWater: TextView, description: TextView)

        fun retriveDataSpecies(bundle: Bundle?, activity: MainActivity, fragment: SpeciesDetailFragment, image: ImageView, namaitem: TextView,
                        classification: TextView, designation: TextView, averageHeight: TextView, averageLifeSpan: TextView,
                        hairColor: TextView, skinColor: TextView, eyeColor: TextView, homeWorld: TextView, language: TextView,
                        description: TextView, list: RecyclerView)

        fun retriveDataStarShips(bundle: Bundle?, activity: MainActivity, fragment: StarShipsDetailFragment, image: ImageView, namaitem: TextView,
                        modelTxt: TextView, starShipClass: TextView, manufacturer: TextView, costInCredit: TextView, length: TextView,
                        crew: TextView, passenger: TextView, hyperDriveRating: TextView, MGLT: TextView, cargoCap: TextView,
                        consumables: TextView, description: TextView)

        fun retriveDataVehicles(bundle: Bundle?, activity: MainActivity, fragment: VehiclesDetailFragment, image: ImageView, namaitem: TextView,
                        model: TextView, vehicleClass: TextView, manufacturer: TextView, costInCredit: TextView, length: TextView,
                        crew: TextView, passenger: TextView, maxSpeed: TextView, cargoCapacity: TextView, consumables: TextView, description: TextView)
    }
}