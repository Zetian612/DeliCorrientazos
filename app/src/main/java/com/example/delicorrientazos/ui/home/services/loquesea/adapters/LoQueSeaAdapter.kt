package com.example.delicorrientazos.ui.home.services.loquesea.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Local

class LoQueSeaAdapter(private val listLocales: List<Local>, private val onClickListener: (Local) -> Unit): RecyclerView.Adapter<LoQueSeaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoQueSeaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LoQueSeaViewHolder(layoutInflater.inflate(R.layout.item_loquesea, parent, false))
    }

    override fun getItemCount(): Int {
        return listLocales.size
    }

    override fun onBindViewHolder(holder: LoQueSeaViewHolder, position: Int) {
        val item = listLocales[position]
        holder.render(item, onClickListener)
    }
}