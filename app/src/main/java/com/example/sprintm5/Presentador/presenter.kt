package com.example.sprintm5.Presentador

import android.content.ClipData.Item
import com.example.sprintm5.Ipresentador
import com.example.sprintm5.modelos.ItemList
import com.example.sprintm5.modelos.Preferences

class presenter (private val view:Ipresentador){
    private val model: ItemList
    private lateinit var  preferences: Preferences

    init {

        model = ItemList()
    }

   /* fun addItems(key: String, value: String) {

        if (model.addItems(key, value)) {
            view.displayErrorMessageAdd()
            view.updateTotalDonation(model.getDonationAMount())
        } else {
            view.displayErrorMessage()
        }
    }*/

    fun guardaDatos(titulo:String,descripcion:String,cantidad:String,precio:String){

        model.addItems("titulo",titulo)
        model.addItems("descripcion",descripcion)
        model.addItems("precio",precio)
        model.addItems("cantidad",cantidad)
        preferences.saveItemList(model)
        view.displayErrorMessageAdd()

    }
}