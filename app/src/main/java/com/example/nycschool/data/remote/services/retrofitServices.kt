package com.example.nycschool.data.remote.services

import com.example.nycschool.common.Common
import com.example.nycschool.data.remote.model.SATResult
import com.example.nycschool.data.remote.model.SchoolList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServices {

    @GET(Common.SCHOOL_RESULT)
    fun getAllSchools(): Call<List<SchoolList>>

    @GET(Common.SAT_RESULT)
    fun getSATResult(): Call<List<SATResult>>

    companion object {

        var retrofitService: RetrofitServices? = null

        fun getInstance() : RetrofitServices {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Common.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitServices::class.java)
            }
            return retrofitService!!
        }
    }
}