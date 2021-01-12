package com.fatimasousa.catfacts.services

import com.fatimasousa.catfacts.models.FactsModel
import retrofit2.Call
import retrofit2.http.GET

interface FactsService {

    @GET("facts")
    fun list() : Call<List<FactsModel>>

}