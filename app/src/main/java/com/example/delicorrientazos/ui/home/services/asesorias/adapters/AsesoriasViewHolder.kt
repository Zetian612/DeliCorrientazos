package com.example.delicorrientazos.ui.home.services.asesorias.adapters

import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Asesoria

class AsesoriasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val checkBoxItem = view.findViewById<CheckBox>(R.id.checkBoxAsesoriaItem)
    fun render (asesoria: Asesoria) {
        checkBoxItem.text = asesoria.nombre

    }
}