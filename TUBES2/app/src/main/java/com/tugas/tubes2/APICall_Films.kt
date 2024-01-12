package com.tugas.tubes2

import android.content.Context
import android.widget.Toast
import com.tugas.tubes2.model.FilmsResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit.*

object APICall_Films {
    const val baseUrl = "https://www.swapi.tech/api/"
    const val BASE_IMAGE_URL2 = "https://starwars-visualguide.com/assets/img/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): APIService {
        return getRetrofit().create(APIService::class.java)
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
}
