package com.cesar.pizza

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridView)

        val nombres = arrayOf(
            "Americana",
            "Napolitana",
            "Pepperoni",
            "Queso",
            "Romana",
            "Siciliana"
        )

        val imagenes = arrayOf(
            R.drawable.americana,
            R.drawable.napolitana,
            R.drawable.peperoni,
            R.drawable.queso,
            R.drawable.romana,
            R.drawable.siciliana
        )

        val adapter = PizzaAdapter(this, nombres, imagenes)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Pizza: ${nombres[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}