package com.example.delicorrientazos.data.providers

import com.example.delicorrientazos.data.models.Category

class CategoryProvider {
    companion object {
        val listCategories = listOf<Category>(
            Category(1, "Bebidas",true),
            Category(2, "Comida",true),
            Category(3, "Postres",false),
        )
    }
}