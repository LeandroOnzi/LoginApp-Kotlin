package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class USER1LoginActivity : ComponentActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    // Lista de usuários e senhas
    private val users = arrayOf(
        arrayOf("user1", "password1"),
        arrayOf("user2", "password2")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (isValidLogin(username, password)) {
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("USERNAME", username)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidLogin(username: String, password: String): Boolean {
        return users.any { it[0] == username && it[1] == password }
    }
}
