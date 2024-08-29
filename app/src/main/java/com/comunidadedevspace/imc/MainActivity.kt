package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                //Mostrar mensage para usuario

                Snackbar.make(
                    edtPeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_SHORT
                )
                    .show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                //Navegar para proxima tela
                //Criar o layout da proxima tela
                //Passar dados(resultado) para proxima tela
                //intent - Classe do proprio Android

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)

                println("MainActivity = Clicou: " + resultado)
            }
        }
    }
}