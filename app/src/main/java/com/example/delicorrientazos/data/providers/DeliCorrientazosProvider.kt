package com.example.delicorrientazos.data.providers

import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.DeliCorrientazos
import com.example.delicorrientazos.data.models.MenuDeliCorrientazos

class DeliCorrientazosProvider {

    companion object {

        val listCorrientazos = listOf<DeliCorrientazos>(
            DeliCorrientazos(1,"Jugos", R.drawable.jugos, listOf(
                MenuDeliCorrientazos(
                    1,"Jugo de piña", R.drawable.pixlr_bg_result__1_, 5.00),
                MenuDeliCorrientazos(
                    2,"Jugo de naranja", R.drawable.pixlr_bg_result__2_, 5.00),
            )
            ),
            DeliCorrientazos(2,"Postres", R.drawable.postres, listOf(
                MenuDeliCorrientazos(
                    1,"Merengon", R.drawable.pixlr_bg_result__1_, 5.00))
            ),
            DeliCorrientazos(3,"Almuerzos", R.drawable.almuerzos, listOf(
                MenuDeliCorrientazos(
                    1,"Pasta a la boloñesa", R.drawable.spagueti, 5.00),
                MenuDeliCorrientazos(
                    2,"Frijoles", R.drawable.frijoles, 5.00),
                MenuDeliCorrientazos(
                    3,"Bandeja paisa", R.drawable.bandeja, 5.00))
            ),
            DeliCorrientazos(4,"Desayunos", R.drawable.desayunos, listOf(
                MenuDeliCorrientazos(
                    1,"Huevos revueltos", R.drawable.pixlr_bg_result__1_, 5.00))
            ),
            DeliCorrientazos(4,"Antojos", R.drawable.antojos, listOf(
                MenuDeliCorrientazos(
                    1,"Dulces", R.drawable.pixlr_bg_result__1_, 5.00))
            ),
        )
    }
}