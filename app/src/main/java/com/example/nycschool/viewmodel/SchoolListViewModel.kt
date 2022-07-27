package com.example.nycschool.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nycschool.data.remote.model.SchoolList
import com.example.nycschool.data.remote.repository.SchoolListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchoolListViewModel constructor(private val repository: SchoolListRepository) : ViewModel() {
    val schoolList = MutableLiveData<List<SchoolList>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllSchool() {

        val response = repository.getSchoolList()
        response.enqueue(object : Callback<List<SchoolList>> {
            override fun onResponse(call: Call<List<SchoolList>>, response: Response<List<SchoolList>>) {
                schoolList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<SchoolList>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}