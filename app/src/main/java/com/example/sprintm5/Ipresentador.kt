package com.example.sprintm5

import com.example.sprintm5.modelos.ItemCarrito
import com.example.sprintm5.modelos.ItemList

interface Ipresentador {


    fun saveData(itemList: ItemList)

    fun showData()

    fun deleteData()

    fun displayConfirmationMessageAdd()


    fun displayErrorMessageAdd()


    fun displayConfirmationMessageDelete()

}