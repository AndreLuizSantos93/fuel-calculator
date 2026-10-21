package com.example.a10dchallege

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val valorTotal = intent.getDoubleExtra("DISTANCIA CUSTO TOTAL", 0.0)
        val consumoPorLitro = intent.getDoubleExtra("DISTANCIA CONSUMO LITRO", 0.0)
        val precoPorLitro = intent.getDoubleExtra("DISTANCIA PRECO LITRO", 0.0)
        val distanciaTotal = intent.getDoubleExtra("DISTANCIA VALOR", 0.0)

        val tvPrecoViagem = findViewById<TextView>(R.id.tvPrecoViagem)
        val tvConsumoPorLitro = findViewById<TextView>(R.id.tvResultadoConsumo)
        val tvPrecoPorLivro = findViewById<TextView>(R.id.tvResultadoPreco)
        val tvDistanciatotal = findViewById<TextView>(R.id.tvResultadoDistancia)

        val btnNovoCalculo = findViewById<Button>(R.id.btnNovoCalculo)



        tvPrecoViagem.text = String.format("%.2f €", valorTotal)
        tvConsumoPorLitro.text = String.format("%.2f Km/L",consumoPorLitro)
        tvPrecoPorLivro.text = String.format("%.2f €/L", precoPorLitro)
        tvDistanciatotal.text = String.format("%.2f Km", distanciaTotal)
        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }
}