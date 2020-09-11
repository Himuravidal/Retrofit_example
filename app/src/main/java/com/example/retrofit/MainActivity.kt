package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModelExample: ViewModelExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ViewModel
        viewModelExample = ViewModelProvider(this).get(ViewModelExample::class.java)


        viewModelExample.exposeLiveDataFromServer().observe(this, Observer {
            Log.d("OBJETFROMSERVER", "${it.title} ${it.results.toString()}")
        })

    }
}