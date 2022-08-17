package com.example.delicorrientazos.ui.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.auth.LoginActivity


class AccountFragment : Fragment(R.layout.fragment_account) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.buttonGoLogin).setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
    }



}