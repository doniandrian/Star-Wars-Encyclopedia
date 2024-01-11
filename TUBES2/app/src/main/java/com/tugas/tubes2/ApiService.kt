package com.tugas.tubes2

import retrofit.Call
import retrofit.http.GET
import retrofit.http.Url

interface ApiService {
    @GET
    fun getResult(@Url endpoint: String): Call<DataResult>
}