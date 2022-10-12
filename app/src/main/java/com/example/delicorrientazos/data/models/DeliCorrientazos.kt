package com.example.delicorrientazos.data.models

data class DeliCorrientazos(
    var id: Int,
    var name: String,
    var img: Int,
    var menus: List<MenuDeliCorrientazos?>?
) {
}