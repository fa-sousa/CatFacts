package com.fatimasousa.catfacts.service

import com.fatimasousa.catfacts.model.FactsModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("facts")
    fun getServices() : Call<List<FactsModel>>

}