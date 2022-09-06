package com.example.delicorrientazos.ui.home.services.delicias.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.home.services.delicias.Ingredientes

class IngredientesAdapter(private val ingredientesList: List<Ingredientes>): RecyclerView.Adapter<IngredientesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return IngredientesViewHolder(layoutInflater.inflate(R.layout.item_ingredientes, parent, false))
    }

    override fun getItemCount(): Int {
        return ingredientesList.size
    }

    override fun onBindViewHolder(holder: IngredientesViewHolder, position: Int) {
        val item = ingredientesList[position]
        holder.render(item)
    }
}