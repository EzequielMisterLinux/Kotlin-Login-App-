package com.example.materialdesing.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.materialdesing.R
import com.google.android.material.textfield.TextInputEditText

class loginactivity : AppCompatActivity() {

    private lateinit var userInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var loginButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.loginactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        userInput = findViewById(R.id.user)
        passwordInput = findViewById(R.id.password)
        loginButton = findViewById(R.id.login)

        loginButton.setOnClickListener {
            validarCredenciales()
        }

    }

    private fun validarCredenciales() {
        val username = userInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()

        if (username.isEmpty()){
            userInput.error = "El usuario es requeridod"
            return
        }
        if (password.isEmpty()){
            passwordInput.error = "La contraseña es requerida"
            return
        }

        if (password.length < 6){
            passwordInput.error = "La contraseña debe tener al menos 6 caracteres"
            return
        }

        if (username == "humbertoezequiel" && password == "laforzosa123"){

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{

            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }
}


