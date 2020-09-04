package com.example.calculadoraimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularIMC(componente: View){
        val nome_user = nome_usuario.text
        val altura = altura.text.toString().toDouble()
        val peso = peso.text.toString().toDouble()

        val imc = peso / (altura * altura)

        if (nome_user.length > 3 && peso > 0.0 && altura > 0.0){
            if (imc < 18.5){
                //laranja
                val magreza = "$nome_user, seu IMC é ${String.format("%.2f", imc)}, ou seja, está abaixo do peso"

                resultado_imc.text = magreza
                resultado_imc.setTextColor(Color.parseColor("#ffa500"))
                resultado_imc.visibility = View.VISIBLE
            }
            if (imc >= 18.5){
                //azul
                val normal = "$nome_user, seu IMC é ${String.format("%.2f", imc)}, ou seja, está no peso"

                resultado_imc.text = normal
                resultado_imc.setTextColor(Color.parseColor("#4169e1"))
                resultado_imc.visibility = View.VISIBLE
            }
            if (imc > 25.0){
                //vermeho
                val sobrepeso = "$nome_user, seu IMC é ${String.format("%.2f", imc)}, ou seja, está acima do peso"

                resultado_imc.text = sobrepeso
                resultado_imc.setTextColor(Color.parseColor("#ff0000"))
                resultado_imc.visibility = View.VISIBLE
            }
        } else{
            resultado_imc.text = "Por favor verifique se o Nome tem mais de 3 caracteres e se o peso e altura são maior que 0"
            resultado_imc.visibility = View.VISIBLE
        }




    }
}