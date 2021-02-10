package br.com.talitamgr.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainCalcular.setOnClickListener {
            val altura = ednMainAltura.text.toString().trim()
            val peso = ednMainPeso.text.toString().trim()

            
            if (altura.isEmpty()) {
                ednMainAltura.error = "Campo inválido"
                ednMainAltura.requestFocus()
            }
            else if (peso.isEmpty() ) {
                ednMainPeso.error = "Campo inválido"
                ednMainPeso.requestFocus()
            }
            else {
               val peso = peso.toFloat()
                val altura= altura.toFloat() / 100

                val imc = peso / (altura * altura)
                var texto: String = " "

                if(imc >= 40){
                    texto = "com obesidade grave"
                }
                else if(imc >= 30 && imc < 40){
                    texto = "obeso"
                }
                else if (imc > 25.0 && imc<30) {
                    texto = "com sobrepeso"

                } else if (imc >= 18.5 && imc < 25.0) {
                    texto = "com o peso normal"

                } else {
                    texto = "abaixo do peso"

                }

                val df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.CEILING

                val Dimc = df.format(imc)

                AlertDialog.Builder(this)
                    .setMessage("Seu IMC é $Dimc. Você está $texto. Deseja fazer outro cálculo?")
                    .setPositiveButton("Sair") { _, _ ->
                        finish()
                    }
                    .setNeutralButton("Sim") { _, _ -> }
                    .setCancelable(false)
                    .create()
                    .show()


            }

    }

}}




