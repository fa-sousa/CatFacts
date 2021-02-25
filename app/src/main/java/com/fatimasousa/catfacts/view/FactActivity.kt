package com.fatimasousa.catfacts.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fatimasousa.catfacts.R

class FactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToChooseFragment()
        handleButtonClick()
    }

    private fun goToChooseFragment () {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ChooseFactFragment())
                .commit()
    }

    private fun goToShowFragment(textToSend: String) {
        val args = Bundle()
        args.putSerializable("text", textToSend)

        val showFactFragment = ShowFactFragment()
        showFactFragment.arguments = args

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout, showFactFragment)
                .commit()
    }

    private fun handleButtonClick() {
        val btnHome = findViewById<Button>(R.id.btnHome)
        val btnGetFact = findViewById<Button>(R.id.btnGetFact)

        btnHome.setOnClickListener{
            goToChooseFragment()
        }

//        btnGetFact.setOnClickListener{
//            callApi()
//        }
    }
}