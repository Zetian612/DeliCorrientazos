package com.example.delicorrientazos.data.models

data class Producto(
    var id: Int,
    var name: String,
    var price: Int,
    var img: Int,
    var category: Category,
    var hasIngredients: Ingredients//? = null es para que no sea obligatorio
) {
    enum class Ingredients {
        SI, NO
    }
}