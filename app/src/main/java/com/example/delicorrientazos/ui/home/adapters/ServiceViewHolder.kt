package com.example.delicorrientazos.ui.home.adapters

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.databinding.ListContentBinding
import com.example.delicorrientazos.ui.home.Service

class ServiceViewHolder(view: View):RecyclerView.ViewHolder(view){

    val img = view.findViewById<ImageView>(R.id.imageView)
    private val binding = ListContentBinding.bind(view)

    fun render(serviceModel: Service,onClickListener: (Service) -> Unit){
        img.setImageResource(serviceModel.image)
        binding.cardView.setOnClickListener {
            onClickListener(serviceModel)
        }
    }
}

