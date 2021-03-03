package com.fatimasousa.catfacts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.viewmodel.FactActivityViewModel
import kotlinx.android.synthetic.main.fragment_show_fact.*

class ShowFactFragment : Fragment() {

    var context = this@ShowFactFragment
    lateinit var factActivityViewModel: FactActivityViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

       return inflater.inflate(R.layout.fragment_show_fact, container, false )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context = this@ShowFactFragment

        factActivityViewModel = ViewModelProvider(this).get(FactActivityViewModel::class.java)

        factActivityViewModel.getFact()!!.observe(viewLifecycleOwner, { factModel ->

            val msg = factModel.text
            this.txtOnlyFact.text = msg

        })
    }
}

