package com.example.sprintm5.modelos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sprintm5.R

class CarritoAdapter(val productos: ArrayList<ItemCarrito>):RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var vista=LayoutInflater.from(parent.context).inflate(R.layout.item_carrito,parent,false)
        return  ViewHolder(vista)
    }
    override fun getItemCount(): Int {
        return productos.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(productos[position])
    }
    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        init {

        }
        fun bindItems(producto: ItemCarrito){
            var url:String="no"
            val nombre=itemView.findViewById<TextView>(R.id.tituloCarrito)
            nombre.text=producto.nombre
            val descripcion=itemView.findViewById<TextView>(R.id.descripcionCarrito)
            descripcion.text=producto.descripcion
            val precio=itemView.findViewById<TextView>(R.id.precioCarrito)
            precio.text=producto.precio
            val cantidad=itemView.findViewById<TextView>(R.id.itemCantidad)
            cantidad.text=producto.cantidad
            val imagen=itemView.findViewById<ImageView>(R.id.imagenCarrito)

            if (producto.id==1){
                url="https://falabella.scene7.com/is/image/Falabella/gsc_120730583_2783594_1?wid=1500&hei=1500&qlt=70"
            } else if (producto.id==2){

                url="https://traukochile.cl/cdn/shop/products/Sanhattan_Cafe_1_1f41acb3-6ad6-4e2e-960b-82180a237dea_700x.png?v=1680786568"
            }  else if (producto.id==3){
                url="https://www.pz.cl/113354-large_default/botin-casual-panama-jack.jpg"
            }

            Glide.with(itemView.context)
                .load(url)
               .into(imagen)
        }
    }



}