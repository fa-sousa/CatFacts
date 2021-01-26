package com.fatimasousa.catfacts.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.models.FactsModel

class ShowFactFragment : Fragment() {

    private val txtOnlyFact = R.id.txtOnlyFact

    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        inflater.inflate(R.layout.fragment_show_fact, container, true)

        return view
    }

    companion object {
        private val ARG_CAUGHT = ShowFactFragment

        fun newInstance(text: FactsModel): ShowFactFragment {
            val args: Bundle = Bundle()
            args.putSerializable(ARG_CAUGHT.toString(), text)
            val fragment = ShowFactFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
