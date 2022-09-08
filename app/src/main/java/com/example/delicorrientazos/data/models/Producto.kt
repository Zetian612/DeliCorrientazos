package com.example.delicorrientazos.data.models

data class Producto(
    var id: Int,
    var name: String,
    var price: Int,
    var img : Int,
    var ingredients: List<Ingredients>
){

}