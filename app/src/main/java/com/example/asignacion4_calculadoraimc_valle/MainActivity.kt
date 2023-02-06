package com.example.asignacion4_calculadoraimc_valle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: TextView= findViewById(R.id.weight)
        val estatura: TextView= findViewById(R.id.height)
        val rango: TextView= findViewById(R.id.range)
        val estatus: TextView= findViewById(R.id.imc)
        val imc: Button= findViewById(R.id.IMC)

        imc.setOnClickListener{
             var pesoKg: Double= 0.0
             var estaturaMts: Double= 0.0

             try{
                 pesoKg= peso.text.toString().toDouble()
                 estaturaMts= estatura.text.toString().toDouble()
             }
             catch(e: java.lang.Exception){
                 estatus.setText("Favor de introducir valores reales")
                 println(e)
             }

            var resultado= calcular(estaturaMts, pesoKg)
            val formato= "%.2f".format(resultado)
            estatus.setText(formato)

            var salud: String
            var color: Int

            when{
                resultado <18.5->{
                    salud= "Peso Bajo"
                    color= R.color.colorRed
                }
                resultado >= 18.5 && resultado <= 24.9->{
                    salud= "Saludable"
                    color= R.color.colorGreenish
                }
                resultado >=25 && resultado <=29.9->{
                    salud= "Sobrepeso"
                    color= R.color.colorYellow
                }
                resultado >=30 && resultado <=34.9->{
                    salud= "Obesidad Grado 1"
                    color= R.color.colorOrange
                }
                resultado >= 35 && resultado <=39.9->{
                    salud= "Obesidad Grado 2"
                    color= R.color.colorBrown
                }
                resultado >=40->{
                    salud= "Obesidad Grado 3"
                    color= R.color.colorRed
                }
                else -> {
                    salud= "Error"
                    color=0
                }
            }

            rango.setBackgroundResource(color)
            rango.setText(salud)

        }
    }

    fun calcular(height:Double, weight:Double): Double{
        return weight/(height*height)
    }

}