package com.tugas.tubes2

import android.content.Context
import android.widget.Toast
import com.tugas.tubes2.model.DataResult
import com.tugas.tubes2.model.FilmsDetail
import com.tugas.tubes2.model.FilmsResult
import com.tugas.tubes2.model.PeopleDetail
import com.tugas.tubes2.model.PlanetsDetail
import com.tugas.tubes2.model.SpeciesDetail
import com.tugas.tubes2.model.StarShipsDetail
import com.tugas.tubes2.model.VehiclesDetail
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit.*

object APICall {

    fun getRetrovit(): Retrofit {
        return Retrofit.Builder().
        baseUrl(baseUrl).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    fun getApiService(): APIService {
        return getRetrovit().create(APIService::class.java)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getResult(context: Context, endpoint: String, callback: (DataResult) -> Unit) {
        GlobalScope.launch (Dispatchers.IO){
            val call: Call<DataResult> = getApiService().getResult(endpoint)
            call.enqueue(object : Callback<DataResult> {
                override fun onResponse(response: Response<DataResult>?, retrofit: Retrofit?) {
                    if(response!!.isSuccess){
                        val result: DataResult = response.body() as DataResult
                        callback(result)
                    }
                }
                override fun onFailure(t: Throwable?) {
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }
    fun getFilmResult(context: Context, endpoint: String, callback: (FilmsResult) -> Unit) {
        GlobalScope.launch (Dispatchers.IO){
            val call: Call<FilmsResult> = getApiService().getFilmsResult(endpoint)
            call.enqueue(object : Callback<FilmsResult> {
                override fun onResponse(response: Response<FilmsResult>?, retrofit: Retrofit?) {
                    if(response!!.isSuccess){
                        val result: FilmsResult = response.body() as FilmsResult
                        callback(result)
                    }
                }
                override fun onFailure(t: Throwable?) {
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            })
        }


    }

    //get people detail
    @OptIn(DelicateCoroutinesApi::class)
    fun getPeopleDetail(context: Context, endpoint: String, callback: (PeopleDetail) -> Unit) {
        GlobalScope.launch (Dispatchers.IO){
            val call: Call<PeopleDetail> = getApiService().getPeopleDetail(endpoint)
            call.enqueue(object : Callback<PeopleDetail> {
                override fun onResponse(response: Response<PeopleDetail>?, retrofit: Retrofit?) {
                    if(response!!.isSuccess){
                        val result: PeopleDetail = response.body() as PeopleDetail
                        callback(result)
                    }
                }
                override fun onFailure(t: Throwable?) {
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    //get planet detail
    @OptIn(DelicateCoroutinesApi::class)
    fun getPlanetsDetail(context: Context, endpoint: String, callback: (PlanetsDetail) -> Unit) {
        GlobalScope.launch (Dispatchers.IO){
            val call: Call<PlanetsDetail> = getApiService().getPlanetsDetail(endpoint)
            call.enqueue(object : Callback<PlanetsDetail> {
                override fun onResponse(response: Response<PlanetsDetail>?, retrofit: Retrofit?) {
                    if(response!!.isSuccess){
                        val result: PlanetsDetail = response.body() as PlanetsDetail
                        callback(result)
                    }
                }
                override fun onFailure(t: Throwable?) {
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    //get species detail
    @OptIn(DelicateCoroutinesApi::class)
    fun getSpeciesDetail(context: Context, endpoint: String, callback: (SpeciesDetail) -> Unit) {
        GlobalScope.launch (Dispatchers.IO){
            val call: Call<SpeciesDetail> = getApiService().getSpeciesDetail(endpoint)
            call.enqueue(object : Callback<SpeciesDetail> {
                override fun onResponse(response: Response<SpeciesDetail>?, retrofit: Retrofit?) {
                    if(response!!.isSuccess){
                        val result: SpeciesDetail = response.body() as SpeciesDetail
                        callback(result)
                    }
                }
                override fun onFailure(t: Throwable?) {
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    //get starships detail
    @OptIn(DelicateCoroutinesApi::class)
    fun getStarshipsDetail(context: Context, endpoint: String, callback: (StarShipsDetail) -> Unit) {
        GlobalScope.launch (Dispatchers.IO){
            val call: Call<StarShipsDetail> = getApiService().getStarShipsDetail(endpoint)
            call.enqueue(object : Callback<StarShipsDetail> {
                override fun onResponse(response: Response<StarShipsDetail>?, retrofit: Retrofit?) {
                    if(response!!.isSuccess){
                        val result: StarShipsDetail = response.body() as StarShipsDetail
                        callback(result)
                    }
                }
                override fun onFailure(t: Throwable?) {
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    //get vehicles detail
    @OptIn(DelicateCoroutinesApi::class)
    fun getVehiclesDetail(context: Context, endpoint: String, callback: (VehiclesDetail) -> Unit) {
        GlobalScope.launch (Dispatchers.IO){
            val call: Call<VehiclesDetail> = getApiService().getVehiclesDetail(endpoint)
            call.enqueue(object : Callback<VehiclesDetail> {
                override fun onResponse(response: Response<VehiclesDetail>?, retrofit: Retrofit?) {
                    if(response!!.isSuccess){
                        val result: VehiclesDetail = response.body() as VehiclesDetail
                        callback(result)
                    }
                }
                override fun onFailure(t: Throwable?) {
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    //get film detail
    @OptIn(DelicateCoroutinesApi::class)
    fun getFilmsDetail(context: Context, endpoint: String, callback: (FilmsDetail) -> Unit) {
        GlobalScope.launch (Dispatchers.IO){
            val call: Call<FilmsDetail> = getApiService().getFilmsDetail(endpoint)
            call.enqueue(object : Callback<FilmsDetail> {
                override fun onResponse(response: Response<FilmsDetail>?, retrofit: Retrofit?) {
                    if(response!!.isSuccess){
                        val result: FilmsDetail = response.body() as FilmsDetail
                        callback(result)
                    }
                }
                override fun onFailure(t: Throwable?) {
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}

// REFERENSI
// 1. https://www.geeksforgeeks.org/how-to-get-data-from-api-using-retrofit-library-in-android/ (Retrofit)