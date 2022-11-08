package com.example.delicorrientazos.ui.home.services.loquesea.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Local

class LoQueSeaViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    val txtNombreLocal = view.findViewById<TextView>(R.id.txtNombreLocal)
    val img = view.findViewById<ImageView>(R.id.imageViewlocal)
    val cardViewloqsea = view.findViewById<CardView>(R.id.cardViewloqsea)

    fun render(item: Local, onClickListener: (Local) -> Unit) {
        txtNombreLocal.text = item.nombre + " - " + item.direccion
        img.setImageResource(item.img)

        cardViewloqsea.setOnClickListener {
            onClickListener(item)
        }
    }
}
