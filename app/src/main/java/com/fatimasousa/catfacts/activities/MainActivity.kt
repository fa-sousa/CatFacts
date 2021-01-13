package com.fatimasousa.catfacts.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.models.FactsModel
import com.fatimasousa.catfacts.services.FactsService
import com.fatimasousa.catfacts.services.RetrofitClient.Companion.createService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Call API
        val remote = createService(FactsService::class.java)
        val call: Call<List<FactsModel>> = remote.list()

        val response = call.enqueue(object : Callback<List<FactsModel>> {
            override fun onFailure(call: Call<List<FactsModel>>, t: Throwable) {
                val s = t.message
            }

            override fun onResponse(call: Call<List<FactsModel>>, response: Response<List<FactsModel>>) {
                val s = response.body()
            }

        })

        //Fragments
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = ChooseFactFragment()
        fragmentTransaction.add(R.id.fragment_choose_fact, fragment)
//        fragmentTransaction.commit()


    }

}