package com.example.sprintm5.modelos

import android.util.Log

class ItemList {
    // lista de datos
    private val itemsPairs: MutableList<Pair<String, String>> = mutableListOf()

    fun getItemsPairs(): MutableList<Pair<String, String>> {
        Log.d("entro6", itemsPairs.toString())
        return itemsPairs
    }

    fun addItems(key: String, value: String) {
        Log.d("entro2", key)
        Log.d("entro3", value)

        itemsPairs.add(Pair(key, value))
    }


    fun removeItems(key:String){
        itemsPairs.removeAll{it.first==key}
    }


    fun getSerializedString():String{

        return itemsPairs.joinToString(separator = ",") {"${it.first}:${it.second}"}

    }


    fun deserializeFromString(serialized: String?) {



        itemsPairs.clear()


        if (!serialized.isNullOrEmpty()) {

            val pairs = serialized.split(",")



            pairs.forEach { pairString ->

                val keyValue = pairString.split(":")

                if (keyValue.size == 2) {

                    itemsPairs.add((Pair(keyValue[0], keyValue[1])))
                }

            }

        }
    }

    override fun toString():String{

        return itemsPairs.joinToString  ("\n" ){"${it.first}:${it.second}"}
    }

}