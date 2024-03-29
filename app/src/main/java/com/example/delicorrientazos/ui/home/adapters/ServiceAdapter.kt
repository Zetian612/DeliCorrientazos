package com.example.delicorrientazos.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Service

class ServiceAdapter(private val serviceList:List<Service>, private val onClickListener: (Service) -> Unit) : RecyclerView.Adapter<ServiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ServiceViewHolder(layoutInflater.inflate(R.layout.list_content,parent,false))
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val item = serviceList[position]
        holder.render(item,onClickListener)
    }

    override fun getItemCount(): Int = serviceList.size

}