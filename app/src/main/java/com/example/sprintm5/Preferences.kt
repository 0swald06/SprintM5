package com.example.sprintm5

import android.content.Context
import android.content.SharedPreferences
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Preferences(context: Context) {

    companion object {
        private const val SHARED_PREFERENCES_NAME = "sprintm5"
        private const val  KEY_ITEM_LIST= "ItemList"

    }
    // instanciar las preferencias la clase
    private val  sharedPreferences : SharedPreferences=
        context.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveItemList(itemList: ItemList){
        // SE AGREGA PARA COMBINAR LAS LISTAS

        val previousItemList = getItemList().getItemsPairs() // Obtener la lista anterior de palabras
        val combinedItemPairs = ArrayList(previousItemList) // Crear una nueva lista combinada

        combinedItemPairs.addAll(itemList.getItemsPairs()) // Combinar con la nueva lista

        val editor = sharedPreferences.edit()
        editor.putString(KEY_ITEM_LIST, ItemList().apply { getItemsPairs().addAll(combinedItemPairs) }.getSerializedString())
        editor.apply()

    }

    fun getItemList(): ItemList{

        val serializeWordList = sharedPreferences.getString(KEY_ITEM_LIST,"")
        // return  WordList().apply { deserializeFromString(serializeWordList) }
        // agrego esto para no borrar la palabra anterior
        // lamo la clase
        val itemList=ItemList()
        itemList.deserializeFromString(serializeWordList)
        return itemList

    }

    fun getList(): List<Pair<String, String>> {
        val listJson = sharedPreferences.getString(KEY_ITEM_LIST, null)
        if (listJson != null) {
            val type = object : TypeToken<List<Pair<String, String>>>() {}.type
            return gson.fromJson(listJson, type)
        }
        return emptyList()
    }

    fun clearList() {
        sharedPreferences.edit().remove(KEY_ITEM_LIST).apply()
    }

}