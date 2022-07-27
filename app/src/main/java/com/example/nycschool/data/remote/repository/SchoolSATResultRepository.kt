package com.example.nycschool.data.remote.repository

import com.example.nycschool.data.remote.services.RetrofitServices

class SchoolSATResultRepository constructor(private val retrofitService: RetrofitServices) {

    fun getSATResults() = retrofitService.getSATResult()
}