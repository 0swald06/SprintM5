package com.example.sprintm5

class ItemList {
    // lista de datos
    private val itemsPairs: MutableList<Pair<String, String>> = mutableListOf()

    // agrego  para poder que las palabras no borren la anterior y utilzar esta variable en clase SharedPrefences
    // como la varibles esta privada hago un funcion que retorne la lista para poder utilzarla desde preferencias
    fun getItemsPairs(): MutableList<Pair<String, String>> {
        return itemsPairs
    }

    fun addItems(key: String, value: String) {

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