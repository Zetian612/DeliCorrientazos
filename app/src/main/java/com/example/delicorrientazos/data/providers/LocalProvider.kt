package com.example.delicorrientazos.data.providers

import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Local

class LocalProvider {

    companion object {

        val listLocales = listOf<Local>(
            Local(1 , "Terraza Italiana" , "Av. La Marina 123" , 3174639876, R.drawable.terrazaitaliana),
        )
    }
}