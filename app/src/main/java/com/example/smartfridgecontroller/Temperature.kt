package com.example.smartfridgecontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class Temperature : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        val Tempvalues= arrayListOf<Int>()
        for (i in 1..60)
        {
            Tempvalues.add(i)
        }
        val spinner:Spinner=findViewById(R.id.spinner)
        val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,Tempvalues)
        spinner.adapter=adapter
    }
}