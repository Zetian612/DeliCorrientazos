package com.example.delicorrientazos.ui.home.services.delicias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.home.services.delicias.adapters.CartAdapter
import com.example.delicorrientazos.ui.home.services.delicias.adapters.CartProvider

class CartActivity : AppCompatActivity() {

    private var cartMutableList: MutableList<Cart> = CartProvider.cartList.toMutableList()
    private  lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

       initRecyclerView()
    }

    private fun initRecyclerView() {
        cartAdapter = CartAdapter(
            cartList = cartMutableList,
            onClickDelete = {
                position -> onDeletedItem(position)
            }
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = cartAdapter
    }

    private fun onDeletedItem(position: Int) {
        cartMutableList.removeAt(position)
        cartAdapter.notifyItemRemoved(position)
    }


}
