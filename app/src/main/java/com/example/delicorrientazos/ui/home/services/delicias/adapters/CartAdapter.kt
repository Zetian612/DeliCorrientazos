package com.example.delicorrientazos.ui.home.services.delicias.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Cart

class CartAdapter(
    private val cartList: MutableList<Cart>,
    private val onClickDelete:(Int) -> Unit,
    private val onClickPlus:(Int) -> Unit,
    private val onClickMinus:(Int) -> Unit
) : RecyclerView.Adapter<CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(v)
    }
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = cartList[position]
        holder.bind(cart, onClickDelete, onClickPlus, onClickMinus)
    }
    override fun getItemCount(): Int {
        return cartList.size
    }

    fun setListData(cartMutableList: MutableList<Cart>) {
        this.cartList.clear()
        this.cartList.addAll(cartMutableList)
    }

}