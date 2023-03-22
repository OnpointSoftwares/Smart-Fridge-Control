package com.example.smartfridgecontroller

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
class lvAdapter(private val context: Activity, private val title: ArrayList<String>, private val description: ArrayList<String>)
    : ArrayAdapter<String>(context, R.layout.lvadapter, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.lvadapter, null, true)

        val name = rowView.findViewById(R.id.name) as TextView
        val address= rowView.findViewById(R.id.address) as TextView


        name.text = title[position]
        address.text = description[position]

        return rowView
    }
}