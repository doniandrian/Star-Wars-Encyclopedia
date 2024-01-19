package com.tugas.tubes2.presenter

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tugas.tubes2.APICall
import com.tugas.tubes2.BASE_IMAGE_URL
import com.tugas.tubes2.R
import com.tugas.tubes2.view.FilmDetailFragment
import com.tugas.tubes2.view.MainActivity
import com.tugas.tubes2.view.PeopleDetailFragment
import com.tugas.tubes2.view.PlanetDetailFragment
import com.tugas.tubes2.view.SpeciesDetailFragment
import com.tugas.tubes2.view.StarShipsDetailFragment
import com.tugas.tubes2.view.VehiclesDetailFragment
import com.tugas.tubes2.view.adapter.PeopleDetailAdapter
import com.tugas.tubes2.view.adapter.PlanetsDetailAdapter
import com.tugas.tubes2.view.adapter.SpeciesDetailAdapter
import com.tugas.tubes2.view.adapter.StarshipsDetailAdapter
import com.tugas.tubes2.view.adapter.VehiclesDetailAdapter
import com.tugas.tubes2.view.presenterInterface.IDetailAdapter
import com.tugas.tubes2.view.presenterInterface.IDetailFragment

class DetailPresenter: IDetailFragment.Presenter {
    override fun retriveDataFilms(bundle: Bundle?, activity: MainActivity, fragment: FilmDetailFragment, image: ImageView, namaitem: TextView,
                             producerTxt: TextView, episodeTxt: TextView, directorTxt: TextView, releaseDateTxt: TextView, description: TextView,
                             listViewCharacters: RecyclerView, listViewPlanets: RecyclerView, listViewSpecies: RecyclerView, listViewVehicles: RecyclerView,
                             listViewStarships: RecyclerView) {
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")
            //glide
            Glide.with(fragment)
                .load("$BASE_IMAGE_URL/films/$nomor.jpg")
                .into(image)

            APICall.getFilmsDetail(activity, "films/$nomor") { filmsDetail ->
                val FilmsDetail = filmsDetail.result
                namaitem.text = FilmsDetail.properties.title
                producerTxt.text = "Producer: " + FilmsDetail.properties.producer
                episodeTxt.text = "Episode: " + FilmsDetail.properties.episode_id.toString()
                directorTxt.text = "Director: " + FilmsDetail.properties.director
                releaseDateTxt.text = "Release Date: " + FilmsDetail.properties.release_date
                description.text ="Description: " + FilmsDetail.description



                //recycler view people
                val peopleDetailAdapter = PeopleDetailAdapter(FilmsDetail.properties.characters, presenter = DetailAdapterPresenter())
                listViewCharacters.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    peopleDetailAdapter.notifyDataSetChanged()
                    adapter = peopleDetailAdapter
                }

                //recycler view planets
                val planetsDetailAdapter = PlanetsDetailAdapter(FilmsDetail.properties.planets, presenter = DetailAdapterPresenter())
                listViewPlanets.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    planetsDetailAdapter.notifyDataSetChanged()
                    adapter = planetsDetailAdapter
                }

                //recycler view starships
                val starshipsDetailAdapter = StarshipsDetailAdapter(FilmsDetail.properties.starships, presenter = DetailAdapterPresenter())
                listViewStarships.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    starshipsDetailAdapter.notifyDataSetChanged()
                    adapter = starshipsDetailAdapter
                }

                //recycler view vehicles
                val vehiclesDetailAdapter = VehiclesDetailAdapter(FilmsDetail.properties.vehicles, presenter = DetailAdapterPresenter())
                listViewVehicles.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    vehiclesDetailAdapter.notifyDataSetChanged()
                    adapter = vehiclesDetailAdapter
                }

                //recycler view species
                val speciesDetailAdapter = SpeciesDetailAdapter(FilmsDetail.properties.species, presenter = DetailAdapterPresenter())
                listViewSpecies.apply {
                    layoutManager = GridLayoutManager(activity,2)
                    setHasFixedSize(true)
                    speciesDetailAdapter.notifyDataSetChanged()
                    adapter = speciesDetailAdapter
                }
            }
        }
        else{
            namaitem.text = "Data tidak ditemukan"
        }
    }

    override fun retriveDataPeople(bundle: Bundle?, image: ImageView, activity: MainActivity, fragment: PeopleDetailFragment, namaitem: TextView, height: TextView,
                             mass: TextView, haircolor: TextView, skincolor: TextView, eyecolor: TextView, birthyear: TextView, gender: TextView,
                             homeworld: TextView, description: TextView) {
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")
            //glide
            Glide.with(fragment)
                .load("$BASE_IMAGE_URL/characters/$nomor.jpg")
                .into(image)

            APICall.getPeopleDetail(activity, "people/$nomor") { PeopleDetail ->
                val peopleDetail = PeopleDetail.result
                namaitem.text = peopleDetail.properties.name
                height.text ="Height: " + peopleDetail.properties.height
                mass.text = "Mass: " +peopleDetail.properties.mass
                haircolor.text ="Hair Color: " + peopleDetail.properties.hair_color
                skincolor.text = "Skin Color: " +peopleDetail.properties.skin_color
                eyecolor.text = "Eye Color: " +peopleDetail.properties.eye_color
                birthyear.text ="BirthYear: " + peopleDetail.properties.birth_year
                gender.text ="Gender: " + peopleDetail.properties.gender
                homeworld.text ="HomeWorld: " + peopleDetail.properties.homeworld
                description.text ="Description: " + peopleDetail.description

            }
        }
        else{
            namaitem.text = "Data tidak ditemukan"
        }
    }

    override fun retriveDataPlanet(bundle: Bundle?, activity: MainActivity, fragment: PlanetDetailFragment, image: ImageView, namaitem: TextView,
                             diameter: TextView, rotation: TextView, orbital: TextView, gravity: TextView, population: TextView,
                             climate: TextView, terrain: TextView, surfaceWater: TextView, description: TextView) {
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")

            //glide
            Glide.with(fragment)
                .load("$BASE_IMAGE_URL/planets/$nomor.jpg")
                .error(R.drawable.picture_error_icon)
                .into(image)

            APICall.getPlanetsDetail(activity, "planets/$nomor") { planetDetail ->
                val planetDetailList = planetDetail.result
                namaitem.text = planetDetailList.properties.name
                diameter.text = "Diameter: " + planetDetailList.properties.diameter
                rotation.text = "Rotation: " +planetDetailList.properties.rotation_period
                orbital.text = "Orbital: " +planetDetailList.properties.orbital_period
                gravity.text = "Gravity: " +planetDetailList.properties.gravity
                population.text = "Population: " +planetDetailList.properties.population
                climate.text = "Climate: " +planetDetailList.properties.climate
                terrain.text = "Terrain: " +planetDetailList.properties.terrain
                surfaceWater.text = "SurfaceWater: " +planetDetailList.properties.surface_water
                description.text = "Description: " +planetDetailList.description
            }
        }
        else{
            namaitem.text = "Data tidak ditemukan"
        }
    }

    override fun retriveDataSpecies(bundle: Bundle?, activity: MainActivity, fragment: SpeciesDetailFragment, image: ImageView, namaitem: TextView,
                             classification: TextView, designation: TextView, averageHeight: TextView, averageLifeSpan: TextView,
                             hairColor: TextView, skinColor: TextView, eyeColor: TextView, homeWorld: TextView, language: TextView,
                             description: TextView, list: RecyclerView) {
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")

            //glide
            Glide.with(fragment)
                .load("$BASE_IMAGE_URL/species/$nomor.jpg")
                .error(R.drawable.picture_error_icon)
                .into(image)

            APICall.getSpeciesDetail(activity, "species/$nomor") { speciesDetail ->
                val speciesDetailList = speciesDetail.result
                namaitem.text = speciesDetailList.properties.name
                classification.text = "Classification: " + speciesDetailList.properties.classification
                designation.text = "Designation: " + speciesDetailList.properties.designation
                averageHeight.text = "Average Height: " + speciesDetailList.properties.average_height
                averageLifeSpan.text = "Average Life Span: " + speciesDetailList.properties.average_lifespan
                hairColor.text = "Hair Color: " + speciesDetailList.properties.hair_colors
                skinColor.text = "Skin Color: " + speciesDetailList.properties.skin_colors
                eyeColor.text = "Eye Color: " + speciesDetailList.properties.eye_colors
                homeWorld.text = "HomeWorld: " + speciesDetailList.properties.homeworld
                language.text = "Language: " + speciesDetailList.properties.language
                description.text = "Description: " + speciesDetailList.description

                val peopleDetailAdapter = PeopleDetailAdapter(speciesDetailList.properties.people, presenter = DetailAdapterPresenter())
                list.apply {
                    layoutManager = LinearLayoutManager(activity)
                    setHasFixedSize(true)
                    peopleDetailAdapter.notifyDataSetChanged()
                    adapter = peopleDetailAdapter

                }
            }
        }
        else{
            namaitem.text = "Data tidak ditemukan"
        }
    }

    override fun retriveDataStarShips(bundle: Bundle?, activity: MainActivity, fragment: StarShipsDetailFragment, image: ImageView, namaitem: TextView,
                             modelTxt: TextView, starShipClass: TextView, manufacturer: TextView, costInCredit: TextView, length: TextView,
                             crew: TextView, passenger: TextView, hyperDriveRating: TextView, MGLT: TextView, cargoCap: TextView,
                             consumables: TextView, description: TextView) {
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")

            //glide
            Glide.with(fragment)
                .load("$BASE_IMAGE_URL/starships/$nomor.jpg")
                .error(R.drawable.picture_error_icon)
                .into(image)

            APICall.getStarshipsDetail(activity, "starships/$nomor") { starshipsDetail ->
                val starShipDetail = starshipsDetail.result
                namaitem.text = starShipDetail.properties.name
                modelTxt.text = "Model: " + starShipDetail.properties.model
                starShipClass.text = "Starship Class: " + starShipDetail.properties.starship_class
                manufacturer.text = "Manufacturer: " + starShipDetail.properties.manufacturer
                costInCredit.text = "Cost In Credit: " + starShipDetail.properties.cost_in_credits
                length.text = "Length: " + starShipDetail.properties.length
                crew.text = "Crew: " + starShipDetail.properties.crew
                passenger.text = "Passenger: " + starShipDetail.properties.passengers
                hyperDriveRating.text = "Hyperdrive Rating: " + starShipDetail.properties.hyperdrive_rating
                MGLT.text = "MGLT: " + starShipDetail.properties.MGLT
                cargoCap.text = "Cargo Capacity: " + starShipDetail.properties.cargo_capacity
                consumables.text = "Consumables: " + starShipDetail.properties.consumables
                description.text = "Description: " + starShipDetail.description
            }

        }
        else{
            namaitem.text = "Data tidak ditemukan"
        }
    }

    override fun retriveDataVehicles(bundle: Bundle?, activity: MainActivity, fragment: VehiclesDetailFragment, image: ImageView, namaitem: TextView,
                             model: TextView, vehicleClass: TextView, manufacturer: TextView, costInCredit: TextView, length: TextView,
                             crew: TextView, passenger: TextView, maxSpeed: TextView, cargoCapacity: TextView, consumables: TextView, description: TextView) {
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")

            //glide
            Glide.with(fragment)
                .load("$BASE_IMAGE_URL/vehicles/$nomor.jpg")
                .error(R.drawable.picture_error_icon)
                .into(image)

            APICall.getVehiclesDetail(activity, "vehicles/$nomor") { vehilesDetail ->
                val vehiclesDetails = vehilesDetail.result
                namaitem.text = vehiclesDetails.properties.name
                model.text = "Model: " + vehiclesDetails.properties.model
                vehicleClass.text = "Vehicle Class: " + vehiclesDetails.properties.vehicle_class
                manufacturer.text = "Manufacturer: " + vehiclesDetails.properties.manufacturer
                costInCredit.text = "Cost In Credit: " + vehiclesDetails.properties.cost_in_credits
                length.text = "Length: " + vehiclesDetails.properties.length
                crew.text = "Crew: " + vehiclesDetails.properties.crew
                passenger.text = "Passenger: " + vehiclesDetails.properties.passengers
                maxSpeed.text = "Max Speed: " + vehiclesDetails.properties.max_atmosphering_speed
                cargoCapacity.text = "Cargo Capacity: " + vehiclesDetails.properties.cargo_capacity
                consumables.text = "Consumables: " + vehiclesDetails.properties.consumables
                description.text = "Description: " + vehiclesDetails.description
            }
        }
        else{
            namaitem.text = "Data tidak ditemukan"
        }
    }
}