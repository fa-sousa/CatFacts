package com.fatimasousa.catfacts.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.models.FactsModel
import com.fatimasousa.catfacts.services.FactsService
import com.fatimasousa.catfacts.services.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChooseFactFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_choose_fact, container, false)

        // Get the activity and widget
        val context = activity as AppCompatActivity
        val btnChooseFact: Button = v.findViewById(R.id.btnChooseFact)


        // Replace fragment
        btnChooseFact.setOnClickListener {

            //Call API
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

            // Pass data to fragment
            val args = Bundle()
            val fragment = ShowFactFragment()
            fragment.arguments = args

        }

        return v
    }
}