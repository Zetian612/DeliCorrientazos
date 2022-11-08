package com.example.delicorrientazos.data.providers

import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Local

class LocalProvider {

    companion object {

        val listLocales = listOf<Local>(
            Local(1 , "San Diego Gelato & Food" , "Calle 23B sur # 25-04 B SanJorge" , 3108542217, Local.Type.COMIDA, R.drawable.sandiego),
            Local(2 , "DarGrill Restaurante" , "Calle 5 #6-44" , 3108542217,Local.Type.COMIDA,  R.drawable.dargrill2),
            Local(3 , "Amalú Gastro-Pub" , "Calle 5 #6-44" , 3188791128,Local.Type.COMIDA,  R.drawable.amalu),
            Local(3 , "Mega Piscinas y servicios SAS" , "Cr 8 #4-37" , 3204924168,Local.Type.SERVICIOS,  R.drawable.megapiscinas),
        )
    }
}