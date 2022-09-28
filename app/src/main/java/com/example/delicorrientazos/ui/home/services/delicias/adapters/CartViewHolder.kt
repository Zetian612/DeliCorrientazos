package com.example.delicorrientazos.ui.home.services.delicias.adapters

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Cart

class CartViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val item_cart_name = view.findViewById<TextView>(R.id.textViewCartName)
    val item_cart_price = view.findViewById<TextView>(R.id.textViewCartPrice)
    val item_cart_quantity = view.findViewById<TextView>(R.id.textViewCartQuantity)
    val item_cart_ingredients = view.findViewById<TextView>(R.id.textViewCartIngredients)
    val item_cart_btn_delete = view.findViewById<ImageButton>(R.id.buttonEliminar)
    val item_cart_btn_add = view.findViewById<Button>(R.id.buttonPlus)
    val item_cart_btn_subtract = view.findViewById<Button>(R.id.buttonMinus)

    fun bind(
        cart: Cart,
        onClickDelete: (Int) -> Unit,
        onClickPlus: (Int) -> Unit,
        onClickMinus: (Int) -> Unit
    ) {
        item_cart_name.text = cart.name
        item_cart_quantity.text = cart.quantity.toString()
        item_cart_price.text = (cart.price * cart.quantity).toString()
        item_cart_ingredients.text = cart.ingredients ?: " "


        item_cart_btn_delete.setOnClickListener {
            onClickDelete(adapterPosition)
        }

        item_cart_btn_add.setOnClickListener {
            onClickPlus(adapterPosition)
        }

        item_cart_btn_subtract.setOnClickListener {
            onClickMinus(adapterPosition)
        }

    }
}