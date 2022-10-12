package com.example.delicorrientazos.ui.home.services.loquesea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Local
import com.example.delicorrientazos.data.providers.LocalProvider
import com.example.delicorrientazos.ui.home.services.loquesea.adapters.LoQueSeaAdapter

class LoQueSeaActivity : AppCompatActivity() {

    private val listLocales = LocalProvider.listLocales
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lo_que_sea)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerLoqSea)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LoQueSeaAdapter(listLocales) { localItem ->
            onItemClicked(localItem)
        }
    }

    private fun onItemClicked(item: Local) {

        val intent = Intent(Intent.ACTION_VIEW)
        val message = "Hola, me gustaría pedir comida de ${item.nombre}"

        intent.data = "https://api.whatsapp.com/send?phone=+57${item.telefono}&text=${message}".toUri()
        startActivity(intent)
    }
}