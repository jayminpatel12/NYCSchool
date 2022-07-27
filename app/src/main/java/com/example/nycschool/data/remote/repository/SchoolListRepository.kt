package com.example.nycschool.data.remote.repository

import com.example.nycschool.data.remote.services.RetrofitServices

class SchoolListRepository constructor(private val retrofitService: RetrofitServices) {

    fun getSchoolList() = retrofitService.getAllSchools()
}