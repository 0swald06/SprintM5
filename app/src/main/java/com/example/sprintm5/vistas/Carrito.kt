package com.example.sprintm5.vistas

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprintm5.R
import com.example.sprintm5.databinding.ActivityCarritoBinding
import com.example.sprintm5.modelos.CarritoAdapter
import com.example.sprintm5.modelos.ItemCarrito
import com.example.sprintm5.modelos.Preferences

class Carrito : AppCompatActivity() {

    private  lateinit var  mBinding: ActivityCarritoBinding
    private lateinit var  preferences: Preferences
    companion object {
        private const val SHARED_PREFERENCES_NAME = "sprintm5"
        private const val  KEY_ITEM_LIST= "ItemList"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        var lista=findViewById<RecyclerView>(R.id.listaCarrito)
        var listaProductos=ArrayList<ItemCarrito>()

        mostrarDatos(listaProductos)

        var adapter = CarritoAdapter(listaProductos)
        lista.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        lista.adapter=adapter

        mBinding.eliminarBTN.setOnClickListener{

            eliminarDatos()

            val i = Intent(this, Carrito::class.java)
            finish()
            overridePendingTransition(0, 0)
            startActivity(i)
            overridePendingTransition(0, 0)
        }

    }


    fun mostrarDatos(list: ArrayList<ItemCarrito>) {
        preferences = Preferences(this)
        val itemList = preferences.getItemList()
        var titulo:ArrayList<String> = ArrayList()
        var descripcion:ArrayList<String> = ArrayList()
        var precio:ArrayList<String> = ArrayList()
        var cantidad:ArrayList<String> = ArrayList()
        var cont:Int=0


        for (pair in itemList.getItemsPairs()) {
            val key = pair.first
            val value = pair.second
            cont++

        if (key=="titulo"){
            titulo.add(value)
        }else if(key=="descripcion"){
            descripcion.add(value)
        }else if(key=="precio"){
            precio.add(value)
        }else if(key=="cantidad"){
            cantidad.add(value)
        }


        }

        for (i in 0 until titulo.size) {
            list.add(ItemCarrito(i,titulo[i],descripcion[i],precio[i],cantidad[i]))
        }
    }

 fun eliminarDatos(){

    preferences.clearList()

}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}




