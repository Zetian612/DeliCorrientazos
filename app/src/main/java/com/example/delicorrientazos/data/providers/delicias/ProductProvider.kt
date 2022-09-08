package com.example.delicorrientazos.data.providers.delicias

import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Ingredients
import com.example.delicorrientazos.data.models.Producto

class ProductProvider {
    companion object {
        var cartList: MutableList<Producto> = mutableListOf(
            Producto(
                1,
                "Empanada",
                2000,
                R.drawable.pixlr_bg_result__2_,
                listOf(
                    Ingredients(1, "Carne"),
                )

            ),
            Producto(
                2,
                "Pastel",
                3000,
                R.drawable.whatsapp_image_2022_08_23_at_6_07_52_pm,
                listOf(
                    Ingredients(1, "Carne"),
                    Ingredients(2, "Pollo"),
                )
            )
        )
    }
}