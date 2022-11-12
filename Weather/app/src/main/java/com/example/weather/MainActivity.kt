package com.example.weather

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.fragments.MainFragment
import org.json.JSONObject

//const val  API_KEY = "064500be650a47f9935131324221111"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder,MainFragment.newInstance())
            .commit()

    }

        //val url = "http://api.weatherapi.com/v1/current.json" +
               // "?key=$API_KEY&q=$name&aqi=no"
    }
