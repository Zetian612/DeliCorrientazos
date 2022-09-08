package com.example.delicorrientazos.ui.home.services.delicias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.db.CartDeliDatabase
import com.example.delicorrientazos.data.db.entities.CartDelicias
import com.example.delicorrientazos.data.models.Cart
import com.example.delicorrientazos.ui.home.services.delicias.adapters.CartAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartActivity : AppCompatActivity() {

    private var cartMutableList: MutableList<Cart> = mutableListOf()
    private  lateinit var cartAdapter: CartAdapter
    private lateinit var db: CartDeliDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

       initRecyclerView()
        db = CartDeliDatabase.getDatabase(this)
        getItemFromDatabase()
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

    private fun getItemFromDatabase() {

        GlobalScope.launch {
            val cartList = db.cartDeliciasDao().getAll()
            runOnUiThread {
                cartMutableList.clear()
                cartMutableList.addAll(cartList)
                cartAdapter.notifyDataSetChanged()
            }
        }

    }

    private fun onDeletedItem(position: Int) {
        cartMutableList.removeAt(position)
        cartAdapter.notifyItemRemoved(position)
    }

    private fun goToWhatsapp() {
        val intent = Intent(Intent.ACTION_VIEW)
        // enviar mensaje a whatsapp con los productos del carrito de compras
        // por termiar !!

        /*val message = "Hola, quisiera pedir: \n" + cartMutableList.joinToString("\n") { it.name }
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=+573187403822&text=$message")
        startActivity(intent)*/


    }


}
