package com.tugas.tubes2.presenter

import android.util.Log
import com.bumptech.glide.Glide
import com.tugas.tubes2.APICall
import com.tugas.tubes2.BASE_IMAGE_URL
import com.tugas.tubes2.R
import com.tugas.tubes2.view.adapter.PeopleDetailAdapter
import com.tugas.tubes2.view.adapter.PlanetsDetailAdapter
import com.tugas.tubes2.view.adapter.SpeciesDetailAdapter
import com.tugas.tubes2.view.adapter.StarshipsDetailAdapter
import com.tugas.tubes2.view.adapter.VehiclesDetailAdapter
import com.tugas.tubes2.view.presenterInterface.IDetailAdapter

class DetailAdapterPresenter: IDetailAdapter.Presenter {
    override fun getDataPeople(holder: PeopleDetailAdapter.PeopleDetailViewHolder, PeopleDetail: List<String>, position: Int) {
        APICall.getPeopleDetail(holder.itemView.context, "people/" + getPersonIdFromUrl(PeopleDetail[position])){ peopleDetail ->
            Log.d("PeopleDetail", peopleDetail.result.properties.name)
            holder.namaitem.text = peopleDetail.result.properties.name

            Glide.with(holder.itemView.context)
                .load(BASE_IMAGE_URL + "characters/" + peopleDetail.result.uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(holder.image)
        }
    }

    override fun getDataPlanets(holder: PlanetsDetailAdapter.PlanetsDetailViewHolder, PlanetsDetail: List<String>, position: Int) {
        APICall.getPeopleDetail(holder.itemView.context, "planets/" + getPersonIdFromUrl(PlanetsDetail[position])){ planetsDetail ->
            holder.namaitem.text = planetsDetail.result.properties.name

            Glide.with(holder.itemView.context)
                .load(BASE_IMAGE_URL + "planets/" + planetsDetail.result.uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(holder.image)
        }
    }

    override fun getDataSpecies(holder: SpeciesDetailAdapter.SpeciesDetailViewHolder, SpeciesDetail: List<String>, position: Int) {
        //call api
        //ambil data people dari api
        APICall.getPeopleDetail(holder.itemView.context, "species/" + getPersonIdFromUrl(SpeciesDetail[position])){ speciesDetail ->
            holder.namaitem.text = speciesDetail.result.properties.name

            Glide.with(holder.itemView.context)
                .load(BASE_IMAGE_URL + "species/" + speciesDetail.result.uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(holder.image)
        }
    }

    override fun getDataStarShips(holder: StarshipsDetailAdapter.StarShipsDetailViewHolder, StarShipsDetail: List<String>, position: Int) {
        APICall.getPeopleDetail(holder.itemView.context, "starships/" + getPersonIdFromUrl(StarShipsDetail[position])){ starShipsDetail ->
            holder.namaitem.text = starShipsDetail.result.properties.name

            Glide.with(holder.itemView.context)
                .load(BASE_IMAGE_URL + "starships/" + starShipsDetail.result.uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(holder.image)
        }
    }

    override fun getDataVehicles(holder: VehiclesDetailAdapter.VehiclesDetailViewHolder, VehiclesDetail: List<String>, position: Int) {
        APICall.getPeopleDetail(holder.itemView.context, "vehicles/" + getPersonIdFromUrl(VehiclesDetail[position])){ vehiclesDetail ->
            holder.namaitem.text = vehiclesDetail.result.properties.name

            Glide.with(holder.itemView.context)
                .load(BASE_IMAGE_URL + "vehicles/" + vehiclesDetail.result.uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(holder.image)
        }
    }

    private fun getPersonIdFromUrl(url: String): String {
        //ambil id dari url
        return url.substringAfterLast("/")
    }
}