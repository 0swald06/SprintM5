package com.example.sprintm5.modelos

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Preferences(context: Context) {


    companion object {
        private const val SHARED_PREFERENCES_NAME = "sprintm5"
        private const val  KEY_ITEM_LIST= "ItemList"
    }


    private val  sharedPreferences : SharedPreferences=
        context.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE)


    fun saveItemList(itemList: ItemList){

        val previousItemList = getItemList().getItemsPairs() // Obtener la lista anterior de palabras
        val combinedItemPairs = ArrayList(previousItemList) // Crear una nueva lista combinada

        combinedItemPairs.addAll(itemList.getItemsPairs()) // Combinar con la nueva lista

        val editor = sharedPreferences.edit()
        editor.putString(KEY_ITEM_LIST, ItemList().apply { getItemsPairs().addAll(combinedItemPairs) }.getSerializedString())
        editor.apply()

    }

    fun getItemList(): ItemList {

        val serializeWordList = sharedPreferences.getString(KEY_ITEM_LIST,"")
        val itemList= ItemList()
        itemList.deserializeFromString(serializeWordList)
        return itemList

    }


    fun clearList() {
        sharedPreferences.edit().clear().commit()
    }

}