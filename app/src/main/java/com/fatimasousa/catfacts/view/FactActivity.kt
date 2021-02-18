package com.fatimasousa.catfacts.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.model.Fact
import com.fatimasousa.catfacts.service.FactsService
import com.fatimasousa.catfacts.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToChooseFragment()
        handleButtonClick()
    }

    private fun callApi () {

        val remote = RetrofitClient.createService(FactsService::class.java)
        val call = remote.list()

        call.enqueue(object : Callback<List<Fact>> {
            override fun onFailure(call: Call<List<Fact>>, t: Throwable) {
                val s = t.message
            }

            override fun onResponse(call: Call<List<Fact>>, response: Response<List<Fact>>) {
                val result = response.body()
                val textToSend = result?.get(2)?.text

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
        showFactFragment.arguments = args

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout, showFactFragment)
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