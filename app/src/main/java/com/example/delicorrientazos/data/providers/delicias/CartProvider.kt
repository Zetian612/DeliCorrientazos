package com.example.delicorrientazos.data.providers.delicias

import com.example.delicorrientazos.data.models.Cart
import com.example.delicorrientazos.data.models.Ingredients

class CartProvider {
    companion object {
        var cartList: MutableList<Cart> = mutableListOf(
            Cart(1, "Empanada",1, "arroz"
            ),
            Cart(2, "Pastel", 1, "arroz"),

        )


    }
}