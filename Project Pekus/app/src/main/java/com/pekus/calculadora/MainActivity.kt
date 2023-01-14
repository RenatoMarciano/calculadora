package com.pekus.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // to show the app bar
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_main)
    }
}