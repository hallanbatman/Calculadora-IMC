package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivityKEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0.0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        println("ResultActivity = Clicou: " + result)

        val classificacao: String = if(result <= 18.5) {
            "Magreza"
        } else if(result > 18.5 && result <= 24.9) {
            "Normal"
        } else if(result > 25 && result <=29.9) {
            "Sobrepeso"
        } else if(result > 30 && result <=39.9) {
            "Obesidade"
        } else {
            "Obesidade grave"
        }

        tvClassificacao.text = classificacao

        }
    }