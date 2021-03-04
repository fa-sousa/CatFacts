package com.fatimasousa.catfacts.repository

import androidx.lifecycle.MutableLiveData
import com.fatimasousa.catfacts.model.FactsModel
import com.fatimasousa.catfacts.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object FactActivityRepository {

    val factModel = MutableLiveData<FactsModel>()

    fun getServicesApiCall(): MutableLiveData<FactsModel> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object: Callback<List<FactsModel>> {
            override fun onFailure(call: Call<List<FactsModel>>, t: Throwable) {
//                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                    call: Call<List<FactsModel>>,
                    response: Response<List<FactsModel>>
            ) {
                val data = response.body()
                val msg = data?.random()?.text

                factModel.value = FactsModel(msg)
            }
        })

        return factModel
    }

}