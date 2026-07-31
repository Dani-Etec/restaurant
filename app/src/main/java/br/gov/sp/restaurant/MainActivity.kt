package br.gov.sp.restaurant

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnEntrar = findViewById<Button>(R.id.buttonEntrar)
        btnEntrar.setOnClickListener {
            val valor = findViewById<TextView>(R.id.textContador).text.toString().toInt()
            val valorAdicionado = valor + 1;

            if (valorAdicionado<=10){
                findViewById<TextView>(R.id.textContador).text = valorAdicionado.toString()
            }else{
                findViewById<TextView>(R.id.textStatus).text = "Esgotado!"
            }
        }



    val btnSair = findViewById<Button>(R.id.buttonSair)
        btnSair.setOnClickListener {
            val valor = findViewById<TextView>(R.id.textContador).text.toString().toInt()
            val valorSub = valor - 1;

            if (valorSub>=0 && valorSub<=10){
                findViewById<TextView>(R.id.textStatus).text = "Pode entrar!"
                findViewById<TextView>(R.id.textContador).text = valorSub.toString()
            }
        }

    }
}