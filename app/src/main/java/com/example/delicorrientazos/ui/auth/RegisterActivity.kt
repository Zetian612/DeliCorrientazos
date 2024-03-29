package com.example.delicorrientazos.ui.auth

import android.app.AlertDialog
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

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        signup()
    }

    private fun signup() {
        title = "Autenticación"
        val signupButton = findViewById<Button>(R.id.signupButton)
        val nameUser = findViewById<EditText>(R.id.nameUser)
        val lastnameUser = findViewById<EditText>(R.id.lastnameUser)
        val signupEmailAddress = findViewById<EditText>(R.id.signupEmailAddress)
        val signupPassword = findViewById<EditText>(R.id.signupPassword)

        signupButton.setOnClickListener {
            if (nameUser.text.isNotEmpty() && lastnameUser.text.isNotEmpty() && signupEmailAddress.text.isNotEmpty() && signupPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(signupEmailAddress.text.toString(), signupPassword.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
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
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error registrando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}