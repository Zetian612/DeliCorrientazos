package com.example.delicorrientazos.ui.home.services.corrientazos.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.DeliCorrientazos

class CorrientazosAdapter(private val listCorrientazos: List<DeliCorrientazos>, private val onClickListener: (DeliCorrientazos) -> Unit): RecyclerView.Adapter<CorrientazosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorrientazosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CorrientazosViewHolder(layoutInflater.inflate(R.layout.item_delicorrientazos, parent, false))
    }

    override fun onBindViewHolder(holder: CorrientazosViewHolder, position: Int) {
        holder.render(listCorrientazos[position], onClickListener)
    }

    override fun getItemCount(): Int {
        return listCorrientazos.size
    }


}