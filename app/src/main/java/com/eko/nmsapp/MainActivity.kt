package com.eko.nmsapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var statusText: TextView
    private val host = "8.8.8.8"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusText = findViewById(R.id.statusText)
        val pingButton: Button = findViewById(R.id.pingButton)

        pingButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val result = NetworkUtils.ping(host)
                withContext(Dispatchers.Main) {
                    statusText.text = if(result) "Host UP" else "Host DOWN"
                }
            }
        }
    }
}