package com.tugas.tubes2

import retrofit.Call
import retrofit.http.GET
import retrofit.http.Url

interface APIService {
    @GET
    fun getResult(@Url endpoint: String): Call<DataResult>

    @GET
    fun getFilmsResult(@Url endpoint: String): Call<FilmsResult>
}