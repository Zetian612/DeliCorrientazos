package com.example.delicorrientazos.ui.home.services.corrientazos.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.MenuDeliCorrientazos

class MenuCorrientazosAdapter(private val listMenuCorrientazos: List<MenuDeliCorrientazos?>?): RecyclerView.Adapter<MenuCorrientazosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCorrientazosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MenuCorrientazosViewHolder(layoutInflater.inflate(R.layout.item_menu_corrientazos, parent, false))
    }

    override fun onBindViewHolder(holder: MenuCorrientazosViewHolder, position: Int) {
        holder.render(listMenuCorrientazos?.get(position))
    }

    override fun getItemCount(): Int {
        return listMenuCorrientazos?.size ?: 0
    }
}