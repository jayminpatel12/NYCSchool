package com.example.nycschool.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nycschool.data.remote.model.SATResult
import com.example.nycschool.data.remote.repository.SchoolSATResultRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchoolSATResultViewModel constructor(private val repository: SchoolSATResultRepository) : ViewModel() {
    val satResult = MutableLiveData<List<SATResult>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllSATResults() {

        val response = repository.getSATResults()
        response.enqueue(object : Callback<List<SATResult>> {
            override fun onResponse(call: Call<List<SATResult>>, response: Response<List<SATResult>>) {
                satResult.postValue(response.body())
            }

            override fun onFailure(call: Call<List<SATResult>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}