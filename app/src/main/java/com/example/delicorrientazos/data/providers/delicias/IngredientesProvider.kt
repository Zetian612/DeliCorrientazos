package com.example.delicorrientazos.data.providers.delicias

import com.example.delicorrientazos.data.models.Ingredients

class IngredientesProvider {
    companion object {
        val ingredientesList = listOf<Ingredients>(
            Ingredients(
                1,
                "Pollo"
            ),
            Ingredients(
                2,
                "Carne"
            ),
            Ingredients(
                3,
                "Pescado"
            ),
            Ingredients(
                4,
                "Chorizo"
            ),
            Ingredients(
                5,
                "Tocineta"
            ),
        )
    }
}