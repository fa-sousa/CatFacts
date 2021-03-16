package com.fatimasousa.catfacts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.viewmodel.FactActivityViewModel
import kotlinx.android.synthetic.main.fragment_show_fact.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowFactFragment : Fragment() {

    private val viewModel : FactActivityViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

       return inflater.inflate(R.layout.fragment_show_fact, container, false )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFact()!!.observe(viewLifecycleOwner, { factModel ->

            val msg = factModel.text
            this.txtOnlyFact.text = msg

            val imagesCat = arrayOf<Int>(
                    R.drawable.image_cat_01,
                    R.drawable.image_cat_02,
                    R.drawable.image_cat_03,
                    R.drawable.image_cat_04
            )

            val imgRandom = imagesCat.random()
            this.imgRandom.setImageResource(imgRandom.toInt())
        })
    }
}


