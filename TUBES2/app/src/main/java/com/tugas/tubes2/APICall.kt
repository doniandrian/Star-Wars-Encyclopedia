package com.tugas.tubes2

import android.content.Context
import android.widget.Toast
import retrofit.*

object APICall {
    const val baseUrl = "https://www.swapi.tech/api/"

    fun getRetrovit(): Retrofit {
        return Retrofit.Builder().
        baseUrl(baseUrl).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    fun getApiService(): APIService {
        return getRetrovit().create(APIService::class.java)
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
