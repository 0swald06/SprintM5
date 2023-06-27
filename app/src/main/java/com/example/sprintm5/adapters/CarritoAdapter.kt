package com.example.sprintm5.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprintm5.R
import com.example.sprintm5.modelos.ItemCarrito

class CarritoAdapter(val productos: ArrayList<ItemCarrito>):RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoAdapter.ViewHolder {

        var vista=LayoutInflater.from(parent.context).inflate(R.layout.item_carrito,parent,false)
        return  ViewHolder(vista)
    }
    override fun getItemCount(): Int {
        return productos.size
    }
    override fun onBindViewHolder(holder: CarritoAdapter.ViewHolder, position: Int) {
        holder.bindItems(productos[position])
    }
    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        init {

        }
        fun bindItems(producto: ItemCarrito){
            val nombre=itemView.findViewById<TextView>(R.id.tituloCarrito)
            nombre.text=producto.nombre
            val descripcion=itemView.findViewById<TextView>(R.id.descripcionCarrito)
            descripcion.text=producto.descripcion
            val precio=itemView.findViewById<TextView>(R.id.precioCarrito)
            precio.text=producto.precio

        }
    }



}