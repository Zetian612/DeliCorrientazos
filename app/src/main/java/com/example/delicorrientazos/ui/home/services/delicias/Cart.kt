package com.example.delicorrientazos.ui.home.services.delicias

data class Cart(
    var id: Int,
    var name: String,
    // list of ingredients
    var ingredients: List<Ingredientes>,
) {
}
