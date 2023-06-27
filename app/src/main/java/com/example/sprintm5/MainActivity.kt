package com.example.sprintm5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprintm5.vistas.fragment_home

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.mainContent,fragment_home()).commit()
        setTitle("Carrito")
    }
}