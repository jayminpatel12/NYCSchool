package com.example.nycschool.common

public interface Common {
    companion object {
        //BASE URL for Network Call
        const val BASE_URL = "https://data.cityofnewyork.us/resource/"

        //END POINT TO FETCH SAT RESULTS
        const val SAT_RESULT = "q52u-2g8j.json"

        //END POINT TO FETCH SCHOOL LIST
        const val SCHOOL_RESULT = "23z9-6uk9.json"
    }
}
