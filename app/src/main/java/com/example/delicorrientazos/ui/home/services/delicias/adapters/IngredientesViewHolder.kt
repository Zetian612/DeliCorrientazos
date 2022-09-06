package com.example.delicorrientazos.ui.home.services.delicias.adapters

import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.home.services.delicias.Ingredientes

class IngredientesViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val ingrediente = view.findViewById<CheckBox>(R.id.checkBoxIngrediente)

    fun render(ingredientesModel: Ingredientes){
        //asignar el id del ingrediente
        ingrediente.id = ingredientesModel.id
        ingrediente.text = ingredientesModel.name

    }

}