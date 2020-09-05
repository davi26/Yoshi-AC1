package com.example.calculodeaes

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

    fun calcular(componente: View){
        val cod_acao = codigo_acao.text
        val qtd_acao = qtd_acao.text.toString().toInt()
        val cotaCompra = valor_compra.text.toString().toDouble()
        val cotaAtual = cotacao_atual.text.toString().toDouble()

        val volume = cotaAtual*qtd_acao
        val lucro_prejuizo = (cotaAtual/cotaCompra-1)*100

        if (cod_acao.length > 3 ){
            val acao = "Ação: $cod_acao"
            resultado_acao.text = acao
            resultado_acao.visibility = View.VISIBLE
        } else {
            Toast.makeText(this, "Favor colocar o Código da ação", Toast.LENGTH_SHORT).show()
        }

        if (qtd_acao > 0){
            val gastos = "Volume(R$): $volume"
            resultado_valorGasto.text = gastos
            resultado_valorGasto.visibility = View.VISIBLE
        } else {
            Toast.makeText(this, "Favor colocar a qtd de ações compradas", Toast.LENGTH_SHORT).show()
        }

        if (cotaCompra > 0.0 && cotaAtual > 0.0){
            val lucroPrejuizo = "Ganho (%): ${String.format("%.2f", lucro_prejuizo)}"
            if (lucro_prejuizo < 0.0){
                resultado_lucro_rejuizo.text = lucroPrejuizo
                resultado_lucro_rejuizo.setTextColor(Color.parseColor("#ff0000"))
                resultado_lucro_rejuizo.visibility = View.VISIBLE
            } else {
                resultado_lucro_rejuizo.text = lucroPrejuizo
                resultado_lucro_rejuizo.setTextColor(Color.parseColor("#008000"))
                resultado_lucro_rejuizo.visibility = View.VISIBLE
            }
        } else {
            Toast.makeText(this, "Favor colocar a cotação de compra e atual da ação", Toast.LENGTH_SHORT).show()
        }

    }
}