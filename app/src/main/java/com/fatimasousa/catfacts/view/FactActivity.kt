package com.fatimasousa.catfacts.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fatimasousa.catfacts.R
import com.fatimasousa.catfacts.repository.FactActivityRepository.callApi
import com.fatimasousa.catfacts.viewmodel.FactActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class FactActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var factActivityViewModel: FactActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@FactActivity

        factActivityViewModel = ViewModelProvider(this).get(FactActivityViewModel::class.java)

        goToChooseFragment()
        handleButtonClick()
    }

    private fun goToChooseFragment () {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ChooseFactFragment())
                .commit()
    }

    private fun handleButtonClick() {

        val btnHome = btnHome
        val btnGetFact = btnGetFact

        btnHome.setOnClickListener{
            goToChooseFragment()
        }

        btnGetFact.setOnClickListener{
            callApi()
        }

    }

    fun goToShowFragment(textToSend: String) {

        factActivityViewModel.getUser()!!.observe(this, { factModel ->

            val args = Bundle()
            args.putSerializable("text", textToSend)

            val showFactFragment = ShowFactFragment()
            showFactFragment.arguments = args

            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, showFactFragment)
                    .commit()
        })
    }
}



//    private fun goToChooseFragment () {
//        supportFragmentManager.beginTransaction()
//                .replace(R.id.frameLayout, ChooseFactFragment())
//                .commit()
//    }
//
//    private fun goToShowFragment(textToSend: String) {
//        val args = Bundle()
//        args.putSerializable("text", textToSend)
//
//        val showFactFragment = ShowFactFragment()
//        showFactFragment.arguments = args
//
//        supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.frameLayout, showFactFragment)
//                .commit()
//    }
//
//    private fun handleButtonClick() {
//        val btnHome = btnHome
//        val btnGetFact = btnGetFact
//
//        btnHome.setOnClickListener{
//            goToChooseFragment()
//        }
//
//        btnGetFact.setOnClickListener{
//            callApi()
//        }
//    }
//}