package com.fatimasousa.catfacts.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fatimasousa.catfacts.R

class ShowFactFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_show_fact, container, false)
    }

}