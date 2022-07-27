package com.example.nycschool.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nycschool.data.remote.repository.SchoolSATResultRepository

class SchoolSATResultViewModelFactory constructor(private val repository: SchoolSATResultRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SchoolSATResultViewModel::class.java)) {
            SchoolSATResultViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}