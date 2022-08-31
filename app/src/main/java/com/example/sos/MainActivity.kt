package com.example.sos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var edt_phone:EditText
    lateinit var send_sos:Button
    lateinit var send_soss:Button
    lateinit var description:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_phone = findViewById(R.id.phone)
        send_sos = findViewById(R.id.sendSOS)
        send_soss = findViewById(R.id.sendSOSsms)
        description = findViewById(R.id.DESCRIPTION)

        send_soss.setOnClickListener{
            sendSOS()
        }

        send_sos.setOnClickListener{
            sendSos()
        }

    }

    private fun sendSOS() {

        val simu = edt_phone.text.toString()
        val descrition = description.text.toString()

        val uri = Uri.parse("smsto:$simu")

        val intent = Intent(Intent.ACTION_SENDTO, uri)

        intent.putExtra("sms_body", "HEELLLPPPP!!!!!! $descrition")

        startActivity(intent)
    }

    private fun sendSos() {

        val Phone = edt_phone.text.toString()


        val phone = "$Phone"

        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

        startActivity(intent)

    }
}