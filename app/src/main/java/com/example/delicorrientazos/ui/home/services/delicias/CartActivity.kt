package com.example.delicorrientazos.ui.home.services.delicias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.db.CartDeliDatabase
import com.example.delicorrientazos.data.models.Cart
import com.example.delicorrientazos.ui.home.services.delicias.adapters.CartAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartActivity : AppCompatActivity() {

    private var cartMutableList: MutableList<Cart> = mutableListOf()
    private var total = 0
    private  lateinit var cartAdapter: CartAdapter
    private lateinit var db: CartDeliDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        db = CartDeliDatabase.getDatabase(this)
        getItemFromDatabase()

        initRecyclerView()
        val btnOrder = findViewById<View>(R.id.checkButtonToWhatsapp)
        val btnvaciar = findViewById<View>(R.id.buttonVaciar)



        btnOrder.setOnClickListener {
            goToWhatsapp()
        }

        btnvaciar.setOnClickListener {
            vaciarCarrito()
        }
    }

    private fun initRecyclerView() {
        //se inicializa el recycler view
        cartAdapter = CartAdapter(
            cartList = cartMutableList,

            onClickDelete = { cart ->
                onDeletedItem(cart)
            },
            onClickPlus = { cart ->
                onPlusItem(cart)
            },
            onClickMinus = { cart ->
                onMinusItem(cart)
            }
        )

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
                getTotal()
            }
        }
    }

    private fun getTotal() {
        val totalTextView = findViewById<TextView>(R.id.textViewTotal)
        // get total from database
        GlobalScope.launch {
            total = db.cartDeliciasDao().getTotal()
            runOnUiThread {
                totalTextView.text = total.toString()
            }
        }
    }

    private fun onDeletedItem(position: Int) {
        val cart = cartMutableList[position]
        GlobalScope.launch {
            db.cartDeliciasDao().deleteById(cart.id)
            runOnUiThread {
                cartMutableList.removeAt(position)
                cartAdapter.notifyItemRemoved(position)
                getTotal()
            }
        }

    }

    private fun vaciarCarrito(){
        GlobalScope.launch {
            db.cartDeliciasDao().deleteAll()
            runOnUiThread {
                cartMutableList.clear()
                cartAdapter.notifyDataSetChanged()
                total = 0
            }
        }

    }

    fun onPlusItem(position: Int){
        val cart = cartMutableList[position]
        cart.quantity = cart.quantity + 1
        GlobalScope.launch {
            db.cartDeliciasDao().updateById(cart.id, cart.quantity)
            runOnUiThread {
                cartAdapter.notifyItemChanged(position)
                getTotal()
            }
        }

    }

    fun onMinusItem(position: Int){
        val cart = cartMutableList[position]
        if (cart.quantity > 1){
            cart.quantity = cart.quantity - 1

            GlobalScope.launch {
                db.cartDeliciasDao().updateById(cart.id, cart.quantity)
                runOnUiThread {
                    cartAdapter.notifyItemChanged(position)
                    getTotal()
                }
            }
        }

    }

    private fun goToWhatsapp() {
        if (cartMutableList.size > 0) {
            val intent = Intent(Intent.ACTION_VIEW)
            // enviar mensaje a whatsapp con los productos y sus ingredientes
            val message = "Hola, quiero ordenar los siguientes productos: \n" +
                    cartMutableList.joinToString(separator = "\n") { cart ->
                        "${cart.quantity} ${cart.name} ${cart.ingredients ?: " "}"
                    }
            intent.data = "https://api.whatsapp.com/send?phone=+573187403822&text=${message}".toUri()
            vaciarCarrito()
            //cerrar activity
            finish()
            startActivity(intent)
        } else {
            Toast.makeText(this, "No hay productos en el carrito", Toast.LENGTH_SHORT).show()
        }
    }


}
