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

class ConsumoPorLitroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo_por_litro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.PrecoCombustivel)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //findViewById
        // Navegar Próxima Tela
        // passar dados entre telas
        // Passar dado do preço e consumo digitado na tela anterior

        val precoCombustivel = intent.getDoubleExtra("PRECO LITRO", 0.0)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_consumoLitro)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val edtConsumoPorLitro = findViewById<EditText>(R.id.edtConsumoPorLitro)
        val btnConsumoPorLitro = findViewById<Button>(R.id.btnConsumoLitroProximo)

        btnConsumoPorLitro.setOnClickListener {

            val consumoPorLitroValor = edtConsumoPorLitro.text.toString().toDouble()
            val intent = Intent(this, DistanciaActivity::class.java)

            intent.putExtra("CONSUMO LITRO", consumoPorLitroValor)
            intent.putExtra("CONSUMO PRECO LITRO", precoCombustivel)

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