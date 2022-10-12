package com.example.delicorrientazos.ui.home.services.corrientazos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.DeliCorrientazos
import com.example.delicorrientazos.data.providers.DeliCorrientazosProvider
import com.example.delicorrientazos.ui.home.services.corrientazos.adapters.CorrientazosAdapter


class CorrientazosActivity : AppCompatActivity() {
    private var listCorrientazos = DeliCorrientazosProvider.listCorrientazos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corrientazos)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerCorrientazos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CorrientazosAdapter(listCorrientazos) { corrientazosItem ->
            onItemSelect(corrientazosItem)
        }
    }

     fun  onItemSelect(item: DeliCorrientazos){
        val men = item.id
        val intent = Intent(this, MenuCorrientazosActivity::class.java)
        intent.putExtra("model",men)
        startActivity(intent)
    }

    //fun getCorrientazos(id: Int): DeliCorrientazos {
     //   return listCorrientazos.find { it.id == id }!!
    //}
}