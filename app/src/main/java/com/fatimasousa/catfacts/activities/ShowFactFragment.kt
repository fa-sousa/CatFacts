package com.fatimasousa.catfacts.activities

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fatimasousa.catfacts.R

class ShowFactFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_show_fact, container, false)

        // Get the activity and widget
        val context = activity as AppCompatActivity
        val btnShowFact: Button = v.findViewById(R.id.btnShowFact)
//        val btnBackChoose: Button = v.findViewById(R.id.btnBackChoose)


        // Replace fragment
        btnShowFact.setOnClickListener {

            val bundle = Bundle()
            val fragment = ShowFactFragment()
            fragment.arguments = bundle

            // Call the extension function for fragment transaction
            context.replaceFragment(fragment)
        }

        return v
    }
}