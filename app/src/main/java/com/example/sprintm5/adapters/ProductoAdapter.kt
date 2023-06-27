package com.example.sprintm5.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavAction
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.sprintm5.R
import com.example.sprintm5.VerProducto
import com.example.sprintm5.databinding.FragmentHomeBinding
import com.example.sprintm5.modelos.Producto
import kotlin.math.log

class ProductoAdapter(val productos: List<Producto>) :RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoAdapter.ViewHolder {

        var vista=LayoutInflater.from(parent.context).inflate(R.layout.item_producto,parent,false)
        return  ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ProductoAdapter.ViewHolder, position: Int) {
        holder.bindItems(productos[position])

    }

    override fun getItemCount(): Int {
        return productos.size
    }
    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        init {

        }

       fun bindItems(producto: Producto){
           itemView.setOnClickListener{
               var intent = Intent(itemView.context,VerProducto::class.java)
           //    intent.putExtra("ID",producto.id)
               intent.putExtra("nombre",producto.nombre)
               intent.putExtra("descripcion",producto.descripcion)
               intent.putExtra("precio",producto.precio)

               itemView.context.startActivity(intent)

           }
            val nombre=itemView.findViewById<TextView>(R.id.item_nombre)
            nombre.text=producto.nombre

            val descripcion=itemView.findViewById<TextView>(R.id.item_descripcion)
           descripcion.text=producto.descripcion

            val precio=itemView.findViewById<TextView>(R.id.item_precio)
           precio.text= producto.precio


       }
    }
}






