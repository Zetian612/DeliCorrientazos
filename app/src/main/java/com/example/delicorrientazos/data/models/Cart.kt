package com.example.delicorrientazos.data.models

data class Cart(
    val id: Int,
    val name: String,
    var quantity: Int,
    val price: Int,
    val ingredients: String? = null,
    ) {
}
