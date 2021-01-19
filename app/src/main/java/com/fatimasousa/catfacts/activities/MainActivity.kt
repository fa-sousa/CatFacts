package com.fatimasousa.catfacts.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.models.FactsModel
import com.fatimasousa.catfacts.services.FactsService
import com.fatimasousa.catfacts.services.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToChooseFragment()
        handleButtonClick()

    }

    private fun callApi () {

        val remote = RetrofitClient.createService(FactsService::class.java)
        val call: Call<List<FactsModel>> = remote.list()

        call.enqueue(object : Callback<List<FactsModel>> {
            override fun onFailure(call: Call<List<FactsModel>>, t: Throwable) {
                val s = t.message
            }

            override fun onResponse(call: Call<List<FactsModel>>, response: Response<List<FactsModel>>) {
                response?.body()?.let {
                    val facts: List<FactsModel> = it
                    configureFacts()
                }
            }
        })

    }

    private fun goToChooseFragment () {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ChooseFactFragment())
                .commit()
    }

    private fun goToShowFragment () {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ShowFactFragment())
                .commit()
    }

    private fun handleButtonClick() {
        val btnHome = findViewById<Button>(R.id.btnHome)
        val btnGetFact = findViewById<Button>(R.id.btnGetFact)

        btnHome.setOnClickListener{
            goToChooseFragment()

        }

        btnGetFact.setOnClickListener{
            callApi()
            goToShowFragment()
        }
    }

    private fun configureFacts() {
        val facts = FactsModel()
        facts.text = R.id.txtOnlyFact.toString()
    }
}