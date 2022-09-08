package com.example.delicorrientazos.ui.home.services.delicias.adapters

import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Ingredients

class IngredientsViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val ingredient = view.findViewById<CheckBox>(R.id.checkBoxIngrediente)

    fun render(ingredientsModel: Ingredients){
        ingredient.text = ingredientsModel.name
    }

}