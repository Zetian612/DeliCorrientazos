package com.example.delicorrientazos.ui.home.services.corrientazos.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.DeliCorrientazos

class CorrientazosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val txtName = view.findViewById<TextView>(R.id.textViewNameCorr)
    val img = view.findViewById<ImageView>(R.id.imageViewCorr)
    val cardViewDelicorrientazos = view.findViewById<CardView>(R.id.cardViewDelicorrientazos)

    fun render(model: DeliCorrientazos, onClickListener: (DeliCorrientazos) -> Unit) {
        txtName.text = model.name
        img.setImageResource(model.img)

        cardViewDelicorrientazos.setOnClickListener {
            onClickListener(model)
        }
    }
}