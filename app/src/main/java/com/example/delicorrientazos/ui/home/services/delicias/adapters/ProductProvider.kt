package com.example.delicorrientazos.ui.home.services.delicias.adapters

import com.example.delicorrientazos.ui.home.services.delicias.Producto

class ProductProvider {
    companion object {
        var productsList = listOf<Producto>(
            Producto(
                1,
                "Empanada"
            ),
            Producto(
                2,
                "Pastel"
            )
        )
    }
}