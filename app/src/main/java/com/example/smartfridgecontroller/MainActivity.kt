package com.example.smartfridgecontroller
import android.Manifest
import android.widget.*
import android.bluetooth.*
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv:ListView=findViewById(R.id.tv)
        val lv:ListView=findViewById(R.id.tv)
        val scanBtn:Button=findViewById(R.id.btnScan)
        lv.setOnItemClickListener(){adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
           startActivity(Intent(this,MainActivity2::class.java))
        }
                    scanBtn.setOnClickListener {
            setupPermissions()
            val BA:BluetoothAdapter=BluetoothAdapter.getDefaultAdapter()
            if(BA==null)
            {
                Toast.makeText(this,"Bluetooth is not supported",Toast.LENGTH_LONG).show()
        }
            else{

                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    Toast.makeText(this,"Permision Not granted",Toast.LENGTH_LONG).show()
                }
                if(BA?.bondedDevices!!.size > 0)
                        {

                            val devname= arrayListOf<String>()
                            val devAddress= arrayListOf<String>()
                            val devices=BA?.bondedDevices
                            if(devices?.size !=null)
                            {
                                for(device in devices)
                                {
                                    devAddress.add(device.address)
                                    devname.add(device.name)
                                }
                            }
                            val adapter=lvAdapter(this,devname,devAddress)
                            lv.adapter=adapter
                        }

                else{
                    Toast.makeText(this,"Bluetooth is not turned on",Toast.LENGTH_LONG).show()
                }
                    }
                }
            }
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.BLUETOOTH_CONNECT)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to record denied")
        }
    }
        }
