package com.example.delicorrientazos.ui.home.services.delicias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.db.AppDatabase
import com.example.delicorrientazos.data.models.Cart
import com.example.delicorrientazos.data.models.Ingredients
import com.example.delicorrientazos.data.providers.delicias.IngredientesProvider
import com.example.delicorrientazos.ui.home.services.delicias.adapters.IngredientsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DeliciasMCProductActivity : AppCompatActivity() {

    val listIngredientsOfProduct = ArrayList<Ingredients>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delicias_mcproduct)
        initRecyclerView()

        // obtener el boton de la actividad
        val btnAdd = findViewById<FloatingActionButton>(R.id.btnAddCartDMC)
        val productId = intent.getIntExtra("product_position", 0)
        val productName = intent.getStringExtra("product_name").toString()

        btnAdd.setOnClickListener {

            // formatear el array de los ingredientes a un string

            val ingredients = listIngredientsOfProduct.joinToString(", ") { it.name }

            val cart = Cart(
                productId,
                productName,
                1,
                ingredients
            ).toString()

            Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("cart", cart)
            startActivity(intent)
        }
        //obtener putExtra
        when(intent.getIntExtra("product_position", 0)){
            1 -> {
                Toast.makeText(this, "Pastel", Toast.LENGTH_SHORT).show()
            }
            2 -> {
                Toast.makeText(this, "Empanada", Toast.LENGTH_SHORT).show()
            }
        }
    }



    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked = view.isChecked
            if (checked) {
                listIngredientsOfProduct.add(Ingredients(1,view.text.toString()))
                Toast.makeText(this, "Se:$listIngredientsOfProduct", Toast.LENGTH_SHORT).show()
            } else {
                listIngredientsOfProduct.remove(Ingredients(1,view.text.toString()))
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewIngredientes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = IngredientsAdapter(IngredientesProvider.ingredientesList)
    }
}