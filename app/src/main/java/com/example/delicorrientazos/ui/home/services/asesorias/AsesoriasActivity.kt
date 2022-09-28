package com.example.delicorrientazos.ui.home.services.asesorias

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Asesoria
import com.example.delicorrientazos.data.models.Ingredients
import com.example.delicorrientazos.data.models.Producto
import com.example.delicorrientazos.data.providers.AsesoriasProvider
import com.example.delicorrientazos.ui.home.services.asesorias.adapters.AsesoriasAdapter
import com.example.delicorrientazos.ui.home.services.delicias.DeliciasMCProductActivity

class AsesoriasActivity : AppCompatActivity() {

    private var listAsesorias = AsesoriasProvider.listAsesorias
    var listAsesoriasSelected = ArrayList<Asesoria>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asesorias)

        initRecyclerView()

        val btnGoToWs = findViewById<Button>(R.id.btnGoToWs)
        btnGoToWs.setOnClickListener {
            getToWhatsapp()
        }
    }

    private fun getToWhatsapp(){
        if (listAsesoriasSelected.size > 0){
            //enviar mensaje a whatsapp con las asesorias seleccionadas
            var message = "Hola, me gustaría recibir asesoría sobre: "
            for (asesoria in listAsesoriasSelected){
                message += "\n- ${asesoria.nombre}"
            }
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=+573187403822&text=$message")
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "Por favor seleccione al menos una asesoría", Toast.LENGTH_SHORT).show()
        }
    }

    fun onCheckboxClickedAsesoria(view: View) {
        if (view is CheckBox) {
            val checked = view.isChecked
            if (checked) {
                listAsesoriasSelected.add(Asesoria(1,view.text.toString()))
            } else {
                listAsesoriasSelected.remove(Asesoria(1,view.text.toString()))
            }
        }
    }


    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerAsesorias)
        val adapter = AsesoriasAdapter(listAsesorias)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}