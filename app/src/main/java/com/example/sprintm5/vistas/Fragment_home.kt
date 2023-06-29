package com.example.sprintm5.vistas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprintm5.R
import com.example.sprintm5.modelos.ProductoAdapter
import com.example.sprintm5.databinding.FragmentHomeBinding
import com.example.sprintm5.modelos.ProductoData


class fragment_home : Fragment() {


    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_home, container, false)
        var recyclerView= view.findViewById<RecyclerView>(R.id.listaProducto)
        val productos = ProductoData().allProductos()
        val url = "https://images.unsplash.com/photo-1639507986194-48ef61205b61?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1176&q=80"


    var adapter = ProductoAdapter(productos)
        //recyclerView.layoutManager=LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager=GridLayoutManager(view.context,2)
        recyclerView.adapter=adapter
        return view
    }


}