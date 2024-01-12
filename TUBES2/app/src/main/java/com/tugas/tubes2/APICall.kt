package com.tugas.tubes2

import android.content.Context
import android.widget.Toast
import retrofit.*

object ApiCall {
    const val baseUrl = "https://www.swapi.tech/api/"
    const val BASE_IMAGE_URL = "https://starwars-visualguide.com/assets/img/"


    fun getRetrovit(): Retrofit {
        return Retrofit.Builder().
        baseUrl(baseUrl).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    fun getApiService(): ApiService {
        return getRetrovit().create(ApiService::class.java)
    }

    fun getResult(context: Context, endpoint: String, callback: (DataResult) -> Unit) {
        val call: Call<DataResult> = getApiService().getResult(endpoint)
        call.enqueue(object : Callback<DataResult> {
            override fun onResponse(response: Response<DataResult>?, retrofit: Retrofit?) {
                if(response!!.isSuccess){
                    val result: DataResult= response.body() as DataResult
                    callback(result)
                }
            }
            override fun onFailure(t: Throwable?) {
                Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
            }
        })
    }



}
