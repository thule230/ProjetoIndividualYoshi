package com.example.appyoshi

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
        if (et_nome.text.toString().equals("")
            || et_horas.text.toString().equals("")
            || et_salario.text.toString().equals("")) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
        }
        else {
            if (et_horas.text.toString().toDouble() <= 0.0 || et_horas.text.toString().toDouble() > 24.0){
                Toast.makeText(this, "Digite uma quantidade de horas válida", Toast.LENGTH_SHORT).show()
            }
            else if (et_salario.text.toString().toDouble() <= 0.0){
                Toast.makeText(this, "Digite um salário válido", Toast.LENGTH_SHORT).show()
            }
            else if (et_nome.text.toString().contains(" ")){
                Toast.makeText(this, "Digite apenas o primeiro nome", Toast.LENGTH_SHORT).show()
            }
            else {
                val valor = String.format("%.2f",
                    et_salario.text.toString().toDouble() / et_horas.text.toString().toDouble()
                ).toDouble()

                var resultado = "${et_nome.text} ganha $valor reais por hora."

                if (valor < 4.75){
                    resultado += " É menos que o salário mínimo"
                    tv_resultado.setTextColor(Color.RED)

                }
                else if (valor == 4.75){
                    resultado += " É o salário mínimo"
                    tv_resultado.setTextColor(Color.parseColor("#fcb103"))
                }
                else {
                    resultado += " É mais que o salário mínimo"
                    tv_resultado.setTextColor(Color.parseColor("#10bf00"))
                }

                tv_resultado.text = resultado
            }
        }
    }
}