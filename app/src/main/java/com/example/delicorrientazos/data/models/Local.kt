package com.example.delicorrientazos.data.models

data class Local(
    val id: Int,
    val nombre: String,
    val direccion: String,
    val telefono: Long,
    val type: Type,
    val img: Int
) {

    enum class Type {
        COMIDA,
        SERVICIOS,
        OTROS
    }
}