package com.task.my_application_sharedpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val prefs = "sharedPrefs"
    private val counter = "counterKey"
    private lateinit var sharedPreferences: SharedPreferences
    private var countervisits: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    private  fun initData(){
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences(prefs, MODE_PRIVATE)
        getData()
        countervisits++
        writeByScreen()
        setData()
    }

    private fun setData(){
        with(sharedPreferences.edit()){
            putInt(counter, countervisits)
            apply()
        }
    }

    private fun getData(){
        countervisits = sharedPreferences.getInt(counter, 0)
    }

    private fun writeByScreen(){
        val textViewCounter: TextView = findViewById(R.id.tvCounterVisits)
        textViewCounter.text = getString(R.string.cantidad_de_visitas, countervisits)
    }
}