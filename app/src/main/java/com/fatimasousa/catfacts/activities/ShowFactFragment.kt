package com.fatimasousa.catfacts.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fatimasousa.catfacts.R

class ShowFactFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_show_fact, container, false)

        val context = activity as AppCompatActivity
        val btnShowFact: Button = view.findViewById(R.id.btnShowFact)
//        val txtShowFact: TextView = view.findViewById(R.id.txtShowFact)
//      val btnBackChoose: Button = v.findViewById(R.id.btnBackChoose)

        btnShowFact.setOnClickListener {

        }

        return view
    }
}