package com.fatimasousa.catfacts.service

import com.fatimasousa.catfacts.model.FactModel
import retrofit2.Call
import retrofit2.http.GET

interface FactsService {

    @GET("facts")
    fun list() : Call<FactModel>

}