package com.aakash.verticalstepper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
    }
}