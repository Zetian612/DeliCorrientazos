package com.example.delicorrientazos.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.delicorrientazos.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //obtener id del boton de registro
        val btnRegistro = findViewById<android.widget.Button>(R.id.signupButton)
        btnRegistro.setOnClickListener {
            //abrir la actividad de registro
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}