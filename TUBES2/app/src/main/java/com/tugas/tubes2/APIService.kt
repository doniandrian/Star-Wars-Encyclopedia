package com.tugas.tubes2

import com.tugas.tubes2.model.DataResult
import com.tugas.tubes2.model.FilmsDetail
import com.tugas.tubes2.model.FilmsResult
import com.tugas.tubes2.model.PeopleDetail
import com.tugas.tubes2.model.PlanetsDetail
import com.tugas.tubes2.model.SpeciesDetail
import com.tugas.tubes2.model.StarShipsDetail
import com.tugas.tubes2.model.VehiclesDetail
import retrofit.Call
import retrofit.http.GET
import retrofit.http.Url

interface APIService {
    @GET
    fun getResult(@Url endpoint: String): Call<DataResult>

    @GET
    fun getFilmsResult(@Url endpoint: String): Call<FilmsResult>


    @GET
    fun getPeopleDetail(@Url endpoint: String): Call<PeopleDetail>

    @GET
    fun getPlanetsDetail(@Url endpoint: String): Call<PlanetsDetail>

    @GET
    fun getFilmsDetail(@Url endpoint: String): Call<FilmsDetail>

    @GET
    fun getSpeciesDetail(@Url endpoint: String): Call<SpeciesDetail>

    @GET
    fun getStarShipsDetail(@Url endpoint: String): Call<StarShipsDetail>

    @GET
    fun getVehiclesDetail(@Url endpoint: String): Call<VehiclesDetail>
}