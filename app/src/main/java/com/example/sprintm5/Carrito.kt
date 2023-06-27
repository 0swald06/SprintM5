package com.example.sprintm5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprintm5.adapters.CarritoAdapter
import com.example.sprintm5.databinding.ActivityCarritoBinding
import com.example.sprintm5.databinding.ActivityVerProductoBinding
import com.example.sprintm5.modelos.ItemCarrito

class Carrito : AppCompatActivity() {
    private lateinit var  preferences: Preferences
    private lateinit var  mBinding: ActivityCarritoBinding
    companion object {
        private const val SHARED_PREFERENCES_NAME = "sprintm5"
        private const val  KEY_ITEM_LIST= "ItemList"

    }
    // instanciar las preferencias la clase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        var lista=findViewById<RecyclerView>(R.id.listaCarrito)
        var listaProductos=ArrayList<ItemCarrito>()
        val myPreferences = Preferences(lista.context)
       // val preferencesList1 = myPreferences.getList()
        val preferencesList2 = myPreferences.getItemList()
        //preferences.clearList()
       // val listaProductos1 = preferencesList1
        val listaProductos2 = preferencesList2.getSerializedString()
        Log.d("prueba123456",listaProductos2)

        mostrarDatos(listaProductos)


        val nombre=intent.getStringExtra("nombre")
        val descripcion=intent.getStringExtra("descripcion")
        val precio=intent.getStringExtra("precio")
        val cantidad=intent.getStringExtra("cantidad")



        var adapter = CarritoAdapter(listaProductos)
        lista.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        lista.adapter=adapter
    }

   /* fun mostrarDatos() {
        preferences = Preferences(this)
        val itemList = preferences.getItemList()
        val itemCarrito=ArrayList<ItemCarrito>()
        itemCarrito=itemList
        // Iterar sobre la lista de pares de palabras y mostrar los datos
        for (pair in itemList.getItemsPairs()) {

        }
    }*/

    fun mostrarDatos(list: ArrayList<ItemCarrito>) {
        preferences = Preferences(this)
        val itemList = preferences.getItemList()
        var titulo:String="no"
        var descripcion:String="no"
        var precio:String="no"
        var cantidad:String="no"
        var cont:Int=0
        var lista:ItemCarrito
        var stringBuilder = StringBuilder()
        // Iterar sobre la lista de pares de palabras y mostrar los datos

        for (pair in itemList.getItemsPairs()) {
            val key = pair.first
            val value = pair.second
            cont++
         /*  when (key) {
                "titulo" -> titulo=value
                "descripcion" -> descripcion=value
                "precio" -> precio=value
                "cantidad" -> cantidad=value
                 else -> {

               }
            }*/
        if (key=="titulo"){titulo=value
        }else if (key=="descripcion"){descripcion=value
        }else if (key=="precio"){precio=value
        }else if (key=="cantidad"){cantidad=value }


            if (cont==4||cont==8||cont==16||cont==20||cont==24||cont==28||cont==32){
                list.add(ItemCarrito(titulo,descripcion,precio,cantidad))

            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}