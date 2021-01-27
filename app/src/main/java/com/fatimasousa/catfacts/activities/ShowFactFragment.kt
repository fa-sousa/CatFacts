package com.fatimasousa.catfacts.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.fatimasousa.catfacts.R


class ShowFactFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

       return inflater.inflate(R.layout.fragment_show_fact, container, false )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.settingFact()

    }

    private fun settingFact(){

        val txtOnlyFactFragment = this.arguments?.getSerializable("text") as String
        val txtOnlyFact = getView()?.findViewById(R.id.txtOnlyFact) as TextView

        txtOnlyFact.setText(txtOnlyFactFragment)

    }

}

