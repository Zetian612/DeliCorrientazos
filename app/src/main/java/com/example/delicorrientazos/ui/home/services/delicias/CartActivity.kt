package com.example.delicorrientazos.ui.home.services.delicias

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Cart
import com.example.delicorrientazos.ui.home.services.delicias.adapters.CartAdapter
import com.example.delicorrientazos.data.providers.delicias.CartProvider

class CartActivity : AppCompatActivity() {

    private var cartMutableList: MutableList<Cart> = CartProvider.cartList.toMutableList()
    private  lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

       initRecyclerView()

        val btnOrder = findViewById<View>(R.id.checkButtonToWhatsapp)
        btnOrder.setOnClickListener {
            goToWhatsapp()
        }
    }

    private fun initRecyclerView() {
        cartAdapter = CartAdapter(
            cartList = cartMutableList
        ) { position ->
            onDeletedItem(position)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = cartAdapter
    }

    private fun onDeletedItem(position: Int) {
        cartMutableList.removeAt(position)
        cartAdapter.notifyItemRemoved(position)
    }

    private fun goToWhatsapp() {
        val intent = Intent(Intent.ACTION_VIEW)
        // enviar mensaje a whatsapp con los productos del carrito de compras
        val message = "Hola, quisiera pedir: \n" + cartMutableList.joinToString("\n") { it.name }
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=+573187403822&text=$message")
        startActivity(intent)


    }


}
