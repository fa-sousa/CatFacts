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

        call.enqueue(object: Callback<FactsModel> {
            override fun onFailure(call: Call<FactsModel>, t: Throwable) {
//                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                    call: Call<FactsModel>,
                    response: Response<FactsModel>
            ) {
//                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()
                val msg = data?.text.toString()
                //val textToSend = result?.get(2)?.text

                factModel.value = FactsModel(msg)
            }
        })

        return factModel
    }

}

//----------------------------------------------------------------

//object FactActivityRepository {
//
//    private fun callApi () {
//
//        val remote = RetrofitClient.createService(FactsService::class.java)
//        val call = remote.list()
//
//        call.enqueue(object : Callback<List<FactModel>> {
//            override fun onFailure(call: Call<List<FactModel>>, t: Throwable) {
//                val s = t.message
//            }
//
//            override fun onResponse(call: Call<List<FactModel>>, response: Response<List<FactModel>>) {
//                val result = response.body()
//                val textToSend = result?.get(2)?.text
//
//                if(textToSend !== null) {
//                    goToShowFragment(textToSend)
//                }
//            }
//        })
//    }
//
//
//
//}