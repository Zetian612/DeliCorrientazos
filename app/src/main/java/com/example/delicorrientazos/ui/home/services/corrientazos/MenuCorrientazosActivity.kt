package com.example.delicorrientazos.ui.home.services.corrientazos


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.MenuDeliCorrientazos
import com.example.delicorrientazos.data.providers.DeliCorrientazosProvider
import com.example.delicorrientazos.ui.home.services.corrientazos.adapters.MenuCorrientazosAdapter

class MenuCorrientazosActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_corrientazos)
        val listmenu = intent.getIntExtra("model",0)
        val listMenuCorrientazos = DeliCorrientazosProvider.listCorrientazos.find { it.id == listmenu }!!.menus


        initRecyclerView(listMenuCorrientazos)
    }


    fun initRecyclerView(menuCorrientazos: List<MenuDeliCorrientazos?>?) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerMenuCorrientazos)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = MenuCorrientazosAdapter(menuCorrientazos)
    }

}