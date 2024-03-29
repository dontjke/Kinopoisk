package com.stepanov.kinopoisk.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stepanov.kinopoisk.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, FilmsFragment.newInstance())
                .commit()
        }
    }
}