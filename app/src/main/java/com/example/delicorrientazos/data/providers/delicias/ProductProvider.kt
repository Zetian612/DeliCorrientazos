package com.example.delicorrientazos.data.providers.delicias

import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Ingredients
import com.example.delicorrientazos.data.models.Producto
import com.example.delicorrientazos.data.providers.CategoryProvider

class ProductProvider {
    companion object {
        var productList: MutableList<Producto> = mutableListOf(
            Producto(
                1,
                "Empanada",
                2000,
                R.drawable.pixlr_bg_result__2_,
                CategoryProvider.listCategories[1],
                Producto.Ingredients.SI
            ),
            Producto(
                2,
                "Pastel",
                3000,
                R.drawable.whatsapp_image_2022_08_23_at_6_07_52_pm,
                CategoryProvider.listCategories[1],
                Producto.Ingredients.SI
            ),
            Producto(
                3,
                "Avena",
                1000,
                R.drawable.pngwing_com,
                CategoryProvider.listCategories[0],
                Producto.Ingredients.NO
            ),
            Producto(
            3,
            "Gaseosa",
            2000,
            R.drawable.gaseosa,
            CategoryProvider.listCategories[0],
            Producto.Ingredients.NO
        )
        )
    }
}