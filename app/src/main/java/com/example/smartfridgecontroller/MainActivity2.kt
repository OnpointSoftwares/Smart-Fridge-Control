package com.example.smartfridgecontroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    private lateinit var btnTemp: Button
    private lateinit var btnSwitch: Button
    private lateinit var btnWeight:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btnSwitch=findViewById(R.id.btnSwitch)
        btnWeight=findViewById(R.id.weightBtn)
         btnTemp=findViewById(R.id.TempBtn)
        btnTemp.setOnClickListener {
            startActivity(Intent(this,Temperature::class.java))
        }
        btnWeight.setOnClickListener {
            startActivity(Intent(this,Weight::class.java))
        }
        btnSwitch.setOnClickListener {
            startActivity(Intent(this,Switch::class.java))
        }

    }
}