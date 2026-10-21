package com.example.a10dchallege

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.PrecoCombustivel)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //findViewById
        // Navegar Próxima Tela
        // fazer calculo
        // Passar todos os dados para próxima tela

        val precoCombustivel = intent.getDoubleExtra("CONSUMO PRECO LITRO", 0.0)
        val consumoPorLitro = intent.getDoubleExtra("CONSUMO LITRO", 0.0)


        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_distancia)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)




        val edtDistancia = findViewById<EditText>(R.id.edtDistancia)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {

            val distancia = edtDistancia.text.toString().toDouble()
            val preco = precoCombustivel
            val consumolitro = consumoPorLitro

            val litroNecessarios = distancia / consumolitro

            val custoTotal = litroNecessarios * preco

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("DISTANCIA CUSTO TOTAL", custoTotal)
            intent.putExtra("DISTANCIA PRECO LITRO", precoCombustivel)
            intent.putExtra("DISTANCIA CONSUMO LITRO", consumolitro)
            intent.putExtra("DISTANCIA VALOR", distancia)

            startActivity(intent)




        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> onOptionsItemSelected(item)
        }
    }
}