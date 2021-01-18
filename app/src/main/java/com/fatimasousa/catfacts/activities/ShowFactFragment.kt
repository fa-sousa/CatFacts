package com.fatimasousa.catfacts.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.models.FactsModel
import com.fatimasousa.catfacts.services.FactsService
import com.fatimasousa.catfacts.services.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowFactFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_show_fact, container, false)

        val context = activity as AppCompatActivity
        val btnShowFact: Button = view.findViewById(R.id.btnShowFact)
        val txtShowFact: TextView = view.findViewById(R.id.txtShowFact)
        val btnBackChoose: Button = view.findViewById(R.id.btnBackChoose)

        btnBackChoose.setOnClickListener {
            startFragment()
        }


        return view
    }

    private fun callApi () {

        val remote = RetrofitClient.createService(FactsService::class.java)
        val call: Call<List<FactsModel>> = remote.list()

        val response = call.enqueue(object : Callback<List<FactsModel>> {
            override fun onFailure(call: Call<List<FactsModel>>, t: Throwable) {
                val s = t.message
            }

            override fun onResponse(call: Call<List<FactsModel>>, response: Response<List<FactsModel>>) {
                val s = response.body()

            }
        })
    }

    private fun startFragment() {
        childFragmentManager.beginTransaction()
                .replace(R.id.fragment_show_fact, ChooseFactFragment())
                .commit()
    }
}