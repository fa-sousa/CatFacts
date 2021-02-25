package com.fatimasousa.catfacts.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fatimasousa.catfacts.model.FactModel
import com.fatimasousa.catfacts.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object FactActivityRepository {

    val factModel = MutableLiveData<FactModel>()

    fun callApi(): MutableLiveData<FactModel> {

        val call = RetrofitClient.factsService.list()

        call.enqueue(object: Callback<FactModel> {
            override fun onFailure(call: Call<FactModel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                    call: Call<FactModel>,
                    response: Response<FactModel>
            ) {
                Log.v("DEBUG : ", response.body().toString())

                val result = response.body()

                val msg = result!!.text

                factModel.value = FactModel()

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