package com.example.calculadoraimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimc.databinding.ActivitySegundaTelaBinding  // Binding correto

class SegundaTela : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaTelaBinding  // Binding atualizado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaTelaBinding.inflate(layoutInflater)  // Corrigido
        setContentView(binding.root)

        binding.calcularButton.setOnClickListener {
            val pesoStr = binding.pesoEdit.text.toString()
            val alturaStr = binding.alturaEdit.text.toString()

            if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                binding.resultadoIMC.text = "Erro: Insira valores válidos"
                return@setOnClickListener
            }

            try {
                val peso = pesoStr.toDouble()
                val altura = alturaStr.toDouble()
                calcularIMC(altura, peso)
            } catch (e: NumberFormatException) {
                binding.resultadoIMC.text = "Erro: Insira números válidos"
            }
        }
    }

    private fun calcularIMC(altura: Double, peso: Double) {
        val usuario = Usuario("Usuário", 0, peso, altura)
        val imc = usuario.calcularIMC()
        val descricao = usuario.descricaoIMC()
        binding.resultadoIMC.text = "IMC: %.2f - %s".format(imc, descricao)
    }
}
class Usuario(val nome: String, val idade: Int, val peso: Double, val altura: Double) {
    fun calcularIMC(): Double = peso / (altura * altura)

    fun descricaoIMC(): String {
        val imc = calcularIMC()
        return when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 24.9 -> "Peso Normal"
            imc < 29.9 -> "Sobrepeso"
            else -> "Obeso"
        }
    }
}