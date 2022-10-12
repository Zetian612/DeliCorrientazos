package com.example.delicorrientazos.ui.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View
import android.widget.Button
import android.widget.TextView

import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType {
    BASIC
}

class AccountFragment : Fragment(R.layout.fragment_account) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.buttonGoLogin).setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }

        view.findViewById<View>(R.id.buttonLogout).setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        if (FirebaseAuth.getInstance().currentUser != null) {
            FirebaseAuth.getInstance().currentUser?.email?.let {
                view?.findViewById<TextView>(R.id.nameUserTxt)?.text = it
                view?.findViewById<Button>(R.id.buttonGoLogin)?.visibility = View.GONE
            }
        } else {
            view?.findViewById<Button>(R.id.buttonLogout)?.visibility = View.GONE
        }
    }



}