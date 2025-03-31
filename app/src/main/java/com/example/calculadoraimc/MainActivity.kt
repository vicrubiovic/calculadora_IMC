package com.example.calculadoraimc

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calcularButton.setOnClickListener{
            val peso = binding.pesoEdit.text.toString().toDouble()
            val altura = binding.alturaEdit.text.toString().toDouble()
            if (peso != null && altura != null){
                calcularIMC(altura, peso)
            }else {
                binding.resultadoIMC.text = "Erro, Porfavor insira valores que sejam validos "
            }

        }
    }
    private fun calcularIMC(altura:Double, peso:Double){
        val usuario = Usuario("Usuario", 0, peso, altura)
        val imc = usuario.calcularIMC()
        val descricao = usuario.descricaoIMC()
        binding.resultadoIMC.text = "IMC: %.2f - %s".format(imc,descricao)
    }
}

class Usuario(val nome: String, val idade: Int, val peso: Double, val altura: Double){

    fun calcularIMC(): Double = peso / (altura * altura)

    fun descricaoIMC(): String{
        val imc = calcularIMC()

        return when{
            imc < 18.5 -> "Abaixo do peso"
            imc < 24.9 -> "Peso Normal"
            imc < 29.9 -> "Sobrepeso"
            else -> "Obeso "
        }
    }

}