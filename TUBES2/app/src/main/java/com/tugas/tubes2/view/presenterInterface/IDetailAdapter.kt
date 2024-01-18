package com.tugas.tubes2.view.presenterInterface

import com.tugas.tubes2.view.adapter.PeopleDetailAdapter
import com.tugas.tubes2.view.adapter.PlanetsDetailAdapter
import com.tugas.tubes2.view.adapter.SpeciesDetailAdapter
import com.tugas.tubes2.view.adapter.StarshipsDetailAdapter
import com.tugas.tubes2.view.adapter.VehiclesDetailAdapter

interface IDetailAdapter {
    interface Presenter {
        fun getDataPeople(holder: PeopleDetailAdapter.PeopleDetailViewHolder, PeopleDetail: List<String>, position: Int)

        fun getDataPlanets(holder: PlanetsDetailAdapter.PlanetsDetailViewHolder, PlanetsDetail: List<String>, position: Int)

        fun getDataSpecies(holder: SpeciesDetailAdapter.SpeciesDetailViewHolder, SpeciesDetail: List<String>, position: Int)

        fun getDataStarShips(holder: StarshipsDetailAdapter.StarShipsDetailViewHolder, StarShipsDetail: List<String>, position: Int)

        fun getDataVehicles(holder: VehiclesDetailAdapter.VehiclesDetailViewHolder, VehiclesDetail: List<String>, position: Int)
    }
}