package com.example.delicorrientazos.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.delicorrientazos.data.db.entities.CartDelicias
import com.example.delicorrientazos.data.models.Cart

@Dao
interface CartDeliciasDao {

    @Query("SELECT * FROM cart_delicias")
    fun getAll(): MutableList<Cart>

    // insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg cartDelicias: CartDelicias)

    // delete
    @Query("DELETE FROM cart_delicias")
    fun deleteAll()

    // delete
    @Query("DELETE FROM cart_delicias WHERE id = :id")
    fun deleteById(id: Int)

}