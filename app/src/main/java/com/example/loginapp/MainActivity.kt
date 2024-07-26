package com.example.loginapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var welcomeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeText = findViewById(R.id.welcome_text)

        val username = intent.getStringExtra("USERNAME")
        welcomeText.text = "Bem-vindo, $username!"
    }
}
