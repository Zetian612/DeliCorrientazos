package com.example.delicorrientazos.ui.home.services.asesorias.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Asesoria

class AsesoriasAdapter(private val listAsesorias: List<Asesoria>): RecyclerView.Adapter<AsesoriasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsesoriasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AsesoriasViewHolder(layoutInflater.inflate(R.layout.item_asesorias, parent, false))
    }

    override fun onBindViewHolder(holder: AsesoriasViewHolder, position: Int) {
        holder.render(listAsesorias[position])
    }

    override fun getItemCount(): Int {
        return listAsesorias.size
    }

}