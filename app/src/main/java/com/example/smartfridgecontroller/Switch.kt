package com.example.smartfridgecontroller

import android.bluetooth.BluetoothSocket
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.IOException
import java.io.OutputStream

class Switch : AppCompatActivity() {
 val btSocket: BluetoothSocket?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch)
        val btnSwitchOff:Button=findViewById(R.id.btnSwitchOff)
        val btnSwitchOn:Button=findViewById(R.id.btnSwitch)
        btnSwitchOff.setOnClickListener {
            turnOffFridge()
        }
        btnSwitchOn.setOnClickListener {
            turnOnFridge()
        }

    }
    fun turnOffFridge()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream()?.write("0".toString().toByte())
            }
            catch (e:IOException)
            {
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun turnOnFridge()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream()?.write("1".toString().toByte())
            }
            catch (e:IOException)
            {
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
            }
        }
    }
}

private fun OutputStream.write(toByte: Byte) {

}
