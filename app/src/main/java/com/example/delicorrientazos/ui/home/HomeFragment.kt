package com.example.delicorrientazos.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Service
import com.example.delicorrientazos.data.providers.ServiceProvider
import com.example.delicorrientazos.databinding.FragmentHomeBinding
import com.example.delicorrientazos.ui.home.adapters.ServiceAdapter
import com.example.delicorrientazos.ui.home.services.asesorias.AsesoriasActivity
import com.example.delicorrientazos.ui.home.services.corrientazos.CorrientazosActivity
import com.example.delicorrientazos.ui.home.services.delicias.DeliciasMcActivity
import com.example.delicorrientazos.ui.home.services.loquesea.LoQueSeaActivity


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
        savedInstanceState: android.os.Bundle?
    ): android.view.View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        if (recyclerView != null) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        if (recyclerView != null) {
            recyclerView.adapter = ServiceAdapter(ServiceProvider.serviceList) { service ->
                onItemSelected(
                    service
                )
            }
        }
    }

    private fun onItemSelected(service: Service) {
        when (service.id){
            1 ->{
                val intent = android.content.Intent(context, AsesoriasActivity::class.java)
                startActivity(intent)
            }
            2 -> {
                val intent = android.content.Intent(context, CorrientazosActivity::class.java)
                startActivity(intent)
            }
            3 -> {
                val intent = android.content.Intent(context, DeliciasMcActivity::class.java)
                startActivity(intent)
            }
            4 -> {
                val intent = android.content.Intent(context, LoQueSeaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
