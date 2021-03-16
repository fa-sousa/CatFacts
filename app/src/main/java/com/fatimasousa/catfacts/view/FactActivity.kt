package com.fatimasousa.catfacts.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fatimasousa.catfacts.R
import kotlinx.android.synthetic.main.activity_main.*

class FactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToChooseFragment()
        handleButtonClick()
    }

    private fun goToChooseFragment () {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout, ChooseFactFragment())
                .commit()
    }

    private fun goToShowFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout, ShowFactFragment())
                .commit()
    }

    private fun handleButtonClick() {

        val btnHome = btnHome
        val btnGetFact = btnGetFact

        btnHome.setOnClickListener{
            goToChooseFragment()
        }

        btnGetFact.setOnClickListener {
            goToShowFragment()
        }
    }
}