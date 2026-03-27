package com.cesar.moneda2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextCantidad: EditText

    private lateinit var radioDolares: RadioButton
    private lateinit var radioSoles: RadioButton
    private lateinit var radioEuro: RadioButton
    private lateinit var radioLibra: RadioButton
    private lateinit var radioRupia: RadioButton
    private lateinit var radioReal: RadioButton
    private lateinit var radioPeso: RadioButton
    private lateinit var radioYuan: RadioButton
    private lateinit var radioYen: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCantidad = findViewById(R.id.editTextText)

        radioDolares = findViewById(R.id.radio0)
        radioSoles = findViewById(R.id.radio1)
        radioEuro = findViewById(R.id.radio2)
        radioLibra = findViewById(R.id.radio3)
        radioRupia = findViewById(R.id.radio4)
        radioReal = findViewById(R.id.radio5)
        radioPeso = findViewById(R.id.radio6)
        radioYuan = findViewById(R.id.radio7)
        radioYen = findViewById(R.id.radio8)
    }

    private fun convertirMoneda() {
        val cantidadTexto = editTextCantidad.text.toString().trim()

        if (cantidadTexto.isEmpty()) {
            mostrarError("Ingresa una cantidad")
            return
        }

        val cantidad = cantidadTexto.toFloatOrNull()
        if (cantidad == null || cantidad <= 0) {
            mostrarError("Ingresa un número válido mayor a 0")
            return
        }

        when {
            radioDolares.isChecked -> {
                val resultado = cantidad * 3.65f
                mostrarResultado("${cantidad} dólares = ${"%.2f".format(resultado)} soles")
            }

            radioSoles.isChecked -> {
                val resultado = cantidad / 3.65f
                mostrarResultado("${cantidad} soles = ${"%.2f".format(resultado)} dólares")
            }

            radioEuro.isChecked -> {
                val resultado = cantidad * 3.9f
                mostrarResultado("${cantidad} euros = ${"%.2f".format(resultado)} soles")
            }

            radioLibra.isChecked -> {
                val resultado = cantidad * 4.5f
                mostrarResultado("${cantidad} libras = ${"%.2f".format(resultado)} soles")
            }

            radioRupia.isChecked -> {
                val resultado = cantidad * 0.044f
                mostrarResultado("${cantidad} rupias = ${"%.2f".format(resultado)} soles")
            }

            radioReal.isChecked -> {
                val resultado = cantidad * 0.73f
                mostrarResultado("${cantidad} reales = ${"%.2f".format(resultado)} soles")
            }

            radioPeso.isChecked -> {
                val resultado = cantidad * 0.21f
                mostrarResultado("${cantidad} pesos = ${"%.2f".format(resultado)} soles")
            }

            radioYuan.isChecked -> {
                val resultado = cantidad * 0.51f
                mostrarResultado("${cantidad} yuanes = ${"%.2f".format(resultado)} soles")
            }

            radioYen.isChecked -> {
                val resultado = cantidad * 0.025f
                mostrarResultado("${cantidad} yenes = ${"%.2f".format(resultado)} soles")
            }

            else -> {
                mostrarError("Selecciona una moneda")
            }
        }
    }

    fun miClicManejador(view: View) {
        if (view.id == R.id.btnConvertir) {
            convertirMoneda()
        }
    }

    private fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        editTextCantidad.requestFocus()
    }

    private fun mostrarResultado(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}