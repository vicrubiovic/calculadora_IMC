package com.example.calculadoraimc

import com.example.calculadoraimc.SegundaTela
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimc.R


class MainActivity : AppCompatActivity() {

    private lateinit var botao: Button  // Corrigi a variável para seguir o padrão camelCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao = findViewById(R.id.Botao)
        botao.setOnClickListener {
            val intent = Intent(this, SegundaTela::class.java) // Criando corretamente o Intent
            startActivity(intent) // Chamando a SegundaTela corretamente
        }
    }
}

