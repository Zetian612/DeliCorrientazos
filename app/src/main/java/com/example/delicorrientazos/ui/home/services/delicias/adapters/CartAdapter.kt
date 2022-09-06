package com.example.delicorrientazos.ui.home.services.delicias.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.home.services.delicias.Cart

class CartAdapter(
    private val cartList: List<Cart>,
    private val onClickDelete:(Int) -> Unit
) : RecyclerView.Adapter<CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(v)
    }
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = cartList[position]
        holder.bind(cart, onClickDelete)
    }
    override fun getItemCount(): Int {
        return cartList.size
    }

}