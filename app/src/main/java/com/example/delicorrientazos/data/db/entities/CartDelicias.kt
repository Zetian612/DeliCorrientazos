package com.example.delicorrientazos.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_delicias")
data class CartDelicias(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "id_product") val idProduct: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "quantity") var quantity: Int,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "category") val category: String?,
    @ColumnInfo(name = "ingredients") val ingredients: String? = null,
    ) {
}

