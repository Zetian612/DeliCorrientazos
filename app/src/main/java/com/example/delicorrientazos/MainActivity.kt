package com.example.delicorrientazos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.delicorrientazos.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navView: BottomNavigationView = findViewById(R.id.navBottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.containerView) as NavHostFragment
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)

    }

    // mostrar mensaje de bienvenida despues de iniciar sesion
    override fun onStart() {
        super.onStart()
        val bundle = intent.extras
        if (bundle != null) {
            val email = bundle.getString("email")
            val provider = bundle.getString("provider")

            Toast.makeText(this, "Bienvenido $email", Toast.LENGTH_LONG).show()
        }
    }
}