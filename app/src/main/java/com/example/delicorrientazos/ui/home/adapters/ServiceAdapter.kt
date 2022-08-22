package com.example.delicorrientazos.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.home.Service

class ServiceAdapter(private val serviceList:List<Service>) :
    RecyclerView.Adapter<ServiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ServiceViewHolder(layoutInflater.inflate(R.layout.list_content,parent,false))
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val item = serviceList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = serviceList.size

}