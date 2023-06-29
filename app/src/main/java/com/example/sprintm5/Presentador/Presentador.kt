package com.example.sprintm5.Presentador

import android.content.ClipData.Item
import android.content.Context
import com.example.sprintm5.Ipresentador
import com.example.sprintm5.modelos.ItemList
import com.example.sprintm5.modelos.Preferences


class Presentador (private val view:Ipresentador){
    private val model: ItemList
    private lateinit var  preferences: Preferences

    init {

        model = ItemList()
    }


    fun saveData(){

        view.displayConfirmationMessageAdd()

    }

    fun showData(){

        view.displayConfirmationMessageAdd()

    }
    fun deleteData(){


        view.displayConfirmationMessageDelete()
    }
}