package com.example.delicorrientazos.ui.home.services.delicias


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delicorrientazos.R
import com.example.delicorrientazos.data.models.Producto
import com.example.delicorrientazos.data.models.Service
import com.example.delicorrientazos.data.providers.delicias.ProductProvider

class DeliciasMcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delicias_mc)

        initRecyclerView()


    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_delicias_mc)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DeliciasAdapter(ProductProvider.cartList) { productItem ->
            onItemSelect(productItem)
        }

    }

    private fun onItemSelect(productItem: Producto) {
        val intent = Intent(this, DeliciasMCProductActivity::class.java)
        intent.putExtra("product_position", productItem.id)
        intent.putExtra("product_name", productItem.name)
        startActivity(intent)
    }

}

class DeliciasAdapter(private val productList: List<Producto>, private val onClickListener: (Producto) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DeliciasViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product_mc,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DeliciasViewHolder -> {
                holder.bind(productList[position],onClickListener)
            }
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}

class DeliciasViewHolder(view: View):RecyclerView.ViewHolder(view) {


    val img = view.findViewById<ImageView>(R.id.imageViewPMC)

    fun bind(producto: Producto, onClickListener: (Producto) -> Unit) {

        img.setImageResource(producto.img)

        itemView.setOnClickListener {
            onClickListener(producto)
        }
    }
}
