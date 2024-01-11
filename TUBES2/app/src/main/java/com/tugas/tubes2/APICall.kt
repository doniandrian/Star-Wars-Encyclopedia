package com.tugas.tubes2

import android.content.Context
import android.widget.Toast
import retrofit.*

class ApiCall {
    fun getResult(context: Context, endpoint: String, callback: (DataResult) -> Unit) {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://www.swapi.tech/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
        val call: Call<DataResult> = service.getResult(endpoint)
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
