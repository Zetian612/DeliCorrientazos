package com.example.delicorrientazos.data.providers

import com.example.delicorrientazos.data.models.Asesoria

class AsesoriasProvider {
    companion object {
        val listAsesorias = listOf<Asesoria>(
            Asesoria(1,"Tramites de pasaporte y visa"),
            Asesoria(2,"Asesorias en paginas web"),
            Asesoria(3,"Publicidad Digital"),
            Asesoria(4,"Comunity Manager"),
            Asesoria(5,"Marketing Digital"),
        )
    }
}