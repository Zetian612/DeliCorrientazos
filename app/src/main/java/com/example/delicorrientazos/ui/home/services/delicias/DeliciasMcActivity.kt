package com.example.delicorrientazos.ui.home.services.delicias

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.ui.home.services.delicias.adapters.IngredientesAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DeliciasMcActivity : AppCompatActivity() {

    val listaIngredientesAgg = ArrayList<Ingredientes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delicias_mc)
        initRecyclerView()

        // obtener el boton de la actividad
        val btnAdd = findViewById<FloatingActionButton>(R.id.btnAddCartDMC)
        btnAdd.setOnClickListener {
            if (listaIngredientesAgg.size > 0) {

                Toast.makeText(this, "Agregado al carrito", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "No has seleccionado ningun ingrediente", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked = view.isChecked
            if (checked) {
                listaIngredientesAgg.add(Ingredientes(1,view.text.toString()))
                Toast.makeText(this, "Se:$listaIngredientesAgg", Toast.LENGTH_SHORT).show()
            } else {
                listaIngredientesAgg.remove(Ingredientes(1,view.text.toString()))
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewIngredientes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = IngredientesAdapter(IngredientesProvider.ingredientesList)
    }


}