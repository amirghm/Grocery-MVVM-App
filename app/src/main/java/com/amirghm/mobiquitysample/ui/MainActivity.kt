package com.amirghm.mobiquitysample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amirghm.mobiquitysample.R
import com.amirghm.mobiquitysample.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}