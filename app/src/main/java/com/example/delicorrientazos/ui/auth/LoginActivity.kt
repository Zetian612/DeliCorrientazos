package com.example.delicorrientazos.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.delicorrientazos.MainActivity
import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.account.AccountFragment
import com.example.delicorrientazos.ui.account.ProviderType
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //obtener id del boton de registro
        val btnRegistro = findViewById<Button>(R.id.signupButton)
        btnRegistro.setOnClickListener {
            //abrir la actividad de registro
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        setup()
        
    }

    fun setup(){
        title = "Autenticación"
        val loginButton = findViewById<Button>(R.id.loginButton)
        val editTextTextEmailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTextPassword2 = findViewById<EditText>(R.id.editTextTextPassword2)

        loginButton.setOnClickListener {
            if (editTextTextEmailAddress.text.isNotEmpty() && editTextTextPassword2.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(editTextTextEmailAddress.text.toString(), editTextTextPassword2.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    }else{
                        showAlert()
                    }
                }
            }
        }

    }

    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

    private fun showAlert() {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: android.app.AlertDialog = builder.create()
        dialog.show()
    }
}