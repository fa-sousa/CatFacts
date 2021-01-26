package com.fatimasousa.catfacts.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.models.FactsModel
import com.fatimasousa.catfacts.services.FactsService
import com.fatimasousa.catfacts.services.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToChooseFragment()
        handleButtonClick()
    }

    private fun callApi () {

        val remote = RetrofitClient.createService(FactsService::class.java)
        val call = remote.list()

        call.enqueue(object : Callback<List<FactsModel>> {
            override fun onFailure(call: Call<List<FactsModel>>, t: Throwable) {
                val s = t.message
            }

            override fun onResponse(call: Call<List<FactsModel>>, response: Response<List<FactsModel>>) {
                val result = response.body()
                val textToSend = result?.get(1)?.text

                if(textToSend !== null) {
                    goToShowFragment(textToSend)
                }
            }
        })
    }

    private fun goToChooseFragment () {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ChooseFactFragment())
                .commit()
    }

    private fun goToShowFragment(textToSend: String) {
        val args = Bundle()
        args.putSerializable("text", textToSend)

        val showFactFragment = ShowFactFragment()
        showFactFragment.arguments.toString()

        supportFragmentManager
                .beginTransaction()
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
        }
    }
}