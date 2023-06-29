package com.example.sprintm5.vistas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprintm5.Ipresentador
import com.example.sprintm5.Presentador.Presentador
import com.example.sprintm5.R
import com.example.sprintm5.databinding.ActivityCarritoBinding
import com.example.sprintm5.modelos.CarritoAdapter
import com.example.sprintm5.modelos.ItemCarrito
import com.example.sprintm5.modelos.ItemList
import com.example.sprintm5.modelos.Preferences

class Carrito : AppCompatActivity(), Ipresentador {

    private  lateinit var  mBinding: ActivityCarritoBinding
    private lateinit var  preferences: Preferences
    private lateinit var  presentador: Presentador
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
        presentador= Presentador(this)
        val itemList = preferences.getItemList()
        var titulo:ArrayList<String> = ArrayList()
        var descripcion:ArrayList<String> = ArrayList()
        var precio:ArrayList<String> = ArrayList()
        var cantidad:ArrayList<String> = ArrayList()
        var imagen:ArrayList<String> = ArrayList()


        for (pair in itemList.getItemsPairs()) {
            val key = pair.first
            val value = pair.second
            Log.d("entro4",itemList.getItemsPairs().toString())

        if (key=="titulo"){
            titulo.add(value)
        }else if(key=="descripcion"){
            descripcion.add(value)
        }else if(key=="precio"){
            precio.add(value)
        }else if(key=="cantidad"){
            cantidad.add(value)
        }else if (key=="imagen"){
            imagen.add(value)}
            Log.d("entro5", imagen.toString())
        }

        for (i in 0 until titulo.size) {

            list.add(ItemCarrito(i,titulo[i],descripcion[i],precio[i],cantidad[i]))
        }
        presentador.showData()
    }

 fun eliminarDatos(){
     preferences.clearList()
   presentador.deleteData()

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
        val toast = Toast.makeText(applicationContext, "Se mostro el producto", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun displayErrorMessageAdd() {
        val toast = Toast.makeText(applicationContext, "No se mostro el producto", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun displayConfirmationMessageDelete() {
        val toast = Toast.makeText(applicationContext, "Se elimino el carrito", Toast.LENGTH_LONG)
        toast.show()
    }
}




