package com.fatimasousa.catfacts.repository

import com.fatimasousa.catfacts.model.FactModel
import com.fatimasousa.catfacts.service.FactsService
import com.fatimasousa.catfacts.service.RetrofitClient
import okhttp3.Call
import okhttp3.Response
import javax.security.auth.callback.Callback

object FactActivityRepository {

    private fun callApi () {

        val remote = RetrofitClient.createService(FactsService::class.java)
        val call = remote.list()

        call.enqueue(object : Callback<List<FactModel>> {
            override fun onFailure(call: Call<List<FactModel>>, t: Throwable) {
                val s = t.message
            }

            override fun onResponse(call: Call<List<FactModel>>, response: Response<List<FactModel>>) {
                val result = response.body()
                val textToSend = result?.get(2)?.text

                if(textToSend !== null) {
                    goToShowFragment(textToSend)
                }
            }
        })
    }


}