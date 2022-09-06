package com.example.delicorrientazos.ui.home.services.delicias.adapters

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.home.services.delicias.Cart

class CartViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    val item_cart_name = view.findViewById<TextView>(R.id.textViewCartName)
    val item_cart_ingredients = view.findViewById<TextView>(R.id.textViewCartIngredients)
    val item_cart_btn_delete = view.findViewById<ImageButton>(R.id.buttonEliminar)

    fun bind(cart: Cart, onClickDelete: (Int) -> Unit) {
        item_cart_name.text = cart.name
        // iterar sobre la lista de ingredientes
        var ingredients = ""
        for (ingredient in cart.ingredients) {
            ingredients += ingredient.name + ", "
        }
        item_cart_ingredients.text = ingredients

        item_cart_btn_delete.setOnClickListener {
            onClickDelete(adapterPosition)
        }

    }
}