package com.example.delicorrientazos.ui.home.services.delicias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.db.CartDeliDatabase
import com.example.delicorrientazos.data.db.entities.CartDelicias
import com.example.delicorrientazos.data.models.Ingredients
import com.example.delicorrientazos.data.providers.delicias.IngredientesProvider
import com.example.delicorrientazos.ui.home.services.delicias.adapters.IngredientsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DeliciasMCProductActivity : AppCompatActivity() {

    val listIngredientsOfProduct = ArrayList<Ingredients>()
    private lateinit var db : CartDeliDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delicias_mcproduct)
        initRecyclerView()

        // obtener el boton de la actividad
        val btnAdd = findViewById<FloatingActionButton>(R.id.btnAddCartDMC)
        db = CartDeliDatabase.getDatabase(this)

        btnAdd.setOnClickListener {
           writeDa()
        }
        //obtener putExtra
        val productI = intent.getIntExtra("product_position", 0)
        val productNam = intent.getStringExtra("product_name").toString()
         Toast.makeText(this, productNam, Toast.LENGTH_SHORT).show()

    }

    private fun writeDa(){
        val productId = intent.getIntExtra("product_position", 0)
        val productName = intent.getStringExtra("product_name").toString()

        // formatear el array de los ingredientes a un string
        val ingredients = listIngredientsOfProduct.joinToString(", ") { it.name }

        if (listIngredientsOfProduct.isNotEmpty()){
            // crear el objeto del carrito
            val cart = CartDelicias(
                null,
                productId,
                productName,
                1,
                ingredients
            )

            // enviar el objeto al carrito
            GlobalScope.launch(Dispatchers.IO) {
                db.cartDeliciasDao().insertAll(cart)
            }

            Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)

        } else {
            Toast.makeText(this, "Seleccione al menos un ingrediente", Toast.LENGTH_SHORT).show()
        }

    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked = view.isChecked
            if (checked) {
                listIngredientsOfProduct.add(Ingredients(1,view.text.toString()))
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