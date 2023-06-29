package com.example.sprintm5.vistas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.sprintm5.Ipresentador
import com.example.sprintm5.Presentador.Presentador
import com.example.sprintm5.modelos.ItemList
import com.example.sprintm5.modelos.Preferences
import com.example.sprintm5.R
import com.example.sprintm5.databinding.ActivityVerProductoBinding
import com.example.sprintm5.databinding.FragmentHomeBinding
import com.example.sprintm5.modelos.Producto
import com.example.sprintm5.modelos.ProductoData

class VerProducto : AppCompatActivity(),Ipresentador {

    private lateinit var  preferences: Preferences
    private lateinit var  mBinding: ActivityVerProductoBinding
    private lateinit var  binding: FragmentHomeBinding
    private lateinit var  presentador: Presentador


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityVerProductoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val id=intent.getStringExtra("id")
        val nombre=intent.getStringExtra("nombre")
        val descripcion=intent.getStringExtra("descripcion")
        val precio=intent.getStringExtra("precio")
        val imagen=intent.getStringExtra("imagen")


        mBinding.tituloProducto.setText(nombre)
        mBinding.descripcionProducto.setText(descripcion)
        mBinding.precioProducto.setText(precio)

        Glide.with(this)
            .load(imagen)
            .into(mBinding.appBarImage)

        mBinding.btnAdd.setOnClickListener{
            guardaDatos()

        }
        mBinding.pagar.setOnClickListener {

             var intent=Intent(this, Carrito::class.java)

             startActivity(intent)
            }

    }
    fun guardaDatos(){
        preferences = Preferences(this)
        presentador=Presentador(this)
        var producto= ProductoData()
        val itemList= ItemList()
        var aux:List<Producto>
        val titulo =mBinding.tituloProducto.text.toString()
        val descripcion =mBinding.descripcionProducto.text.toString()
        val cantidad =mBinding.txtCantidadItem.text.toString()
        val precio =mBinding.precioProducto.text.toString()
        var imagen:String="no"


        val id=intent.getStringExtra("id")

        itemList.addItems("titulo",titulo)
       itemList.addItems("descripcion",descripcion)
        itemList.addItems("precio",precio)
        itemList.addItems("cantidad",cantidad)
        aux=producto.allProductos()
        for (i in 0 until  producto.allProductos().size) {


            if (id== aux[i].id){
                imagen=aux[i].imagen

            }

        }
        Log.d("entro1", imagen)
        itemList.addItems("imagen",imagen)


        preferences.saveItemList(itemList)

        presentador.saveData()

       // preferences.saveItemList(itemList)

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun saveData(itemList: ItemList) {


    }

    override fun showData() {
        TODO("Not yet implemented")
    }

    override fun deleteData() {
        TODO("Not yet implemented")
    }

    override fun displayConfirmationMessageAdd() {
        val toast = Toast.makeText(applicationContext, "Se agrego el producto", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun displayErrorMessageAdd() {
        val toast = Toast.makeText(applicationContext, "No se agrego el producto", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun displayConfirmationMessageDelete() {
        val toast = Toast.makeText(applicationContext, "Se elimino el carrito", Toast.LENGTH_LONG)
        toast.show()
    }

}