package com.fatimasousa.catfacts.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.models.FactsModel

class ShowFactFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        this.arguments?.getSerializable("text") as FactsModel

        return inflater.inflate(R.layout.fragment_show_fact, container, false)
    }

}
