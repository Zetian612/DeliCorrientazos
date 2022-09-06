package com.example.delicorrientazos.ui.home.services.delicias.adapters

import com.example.delicorrientazos.ui.home.services.delicias.Cart
import com.example.delicorrientazos.ui.home.services.delicias.Ingredientes

class CartProvider {
    companion object {
        var cartList: MutableList<Cart> = mutableListOf(
            Cart(1, "Empanada", listOf(
                Ingredientes(1, "Carne"),
                Ingredientes(2, "Pollo"),
            )),
            Cart(2, "Pastel", listOf(
                Ingredientes(1, "Carne")
            )),
        )


    }
}