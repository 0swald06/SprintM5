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
import com.example.sprintm5.Ipresentador
import com.example.sprintm5.modelos.ItemList
import com.example.sprintm5.modelos.Preferences
import com.example.sprintm5.R
import com.example.sprintm5.databinding.ActivityVerProductoBinding
import com.example.sprintm5.modelos.ProductoData

class VerProducto : AppCompatActivity(),Ipresentador {

    private lateinit var  preferences: Preferences
    private lateinit var  mBinding: ActivityVerProductoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityVerProductoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val nombre=intent.getStringExtra("nombre")
        val descripcion=intent.getStringExtra("descripcion")
        val precio=intent.getStringExtra("precio")
        if (nombre != null) {
            Log.d("prueba11", nombre)
        }

        mBinding.tituloProducto.setText(nombre)
        mBinding.descripcionProducto.setText(descripcion)
        mBinding.precioProducto.setText(precio)

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
        val itemList= ItemList()
        val titulo =mBinding.tituloProducto.text.toString()
        val descripcion =mBinding.descripcionProducto.text.toString()
        val cantidad =mBinding.txtCantidadItem.text.toString()
        val precio =mBinding.precioProducto.text.toString()
        itemList.addItems("titulo",titulo)
        itemList.addItems("descripcion",descripcion)
        itemList.addItems("precio",precio)
        itemList.addItems("cantidad",cantidad)
        preferences.saveItemList(itemList)

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
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