package com.fatimasousa.catfacts.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatimasousa.catfacts.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.host, ChooseFactFragment())
                .addToBackStack(null)
                .commit()

    }

}