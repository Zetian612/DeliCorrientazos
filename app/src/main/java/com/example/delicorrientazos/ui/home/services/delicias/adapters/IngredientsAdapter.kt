package com.example.delicorrientazos.ui.home.services.delicias.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Ingredients

class IngredientsAdapter(private val listIngredientsAgg: List<Ingredients>): RecyclerView.Adapter<IngredientsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return IngredientsViewHolder(layoutInflater.inflate(R.layout.item_ingredientes, parent, false))
    }

    override fun getItemCount(): Int {
        return listIngredientsAgg.size
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        val item = listIngredientsAgg[position]
        holder.render(item)
    }
}