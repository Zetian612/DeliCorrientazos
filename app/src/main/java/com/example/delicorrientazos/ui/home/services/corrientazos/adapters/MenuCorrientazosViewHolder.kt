package com.example.delicorrientazos.ui.home.services.corrientazos.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.MenuDeliCorrientazos

class MenuCorrientazosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val txtName = view.findViewById<TextView>(R.id.menuName)
    val txtPrice = view.findViewById<TextView>(R.id.menuPrice)
    val img = view.findViewById<ImageView>(R.id.menuImg)

    fun render(
        menuDeliCorrientazos: MenuDeliCorrientazos?
    ) {
        txtName.text = menuDeliCorrientazos?.name
        txtPrice.text = menuDeliCorrientazos?.price.toString()
        img.setImageResource(menuDeliCorrientazos?.img!!)

        //itemView.setOnClickListener {
       //     onClickListener(menuDeliCorrientazos)
       // }
    }
}