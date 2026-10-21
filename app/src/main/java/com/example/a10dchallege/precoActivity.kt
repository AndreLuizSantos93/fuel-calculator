package com.example.a10dchallege

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class precoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_combustivel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.PrecoCombustivel)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //findViewById
        // Navegar Próxima Tela
        // passar dados entre telas

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_preco)

        //seta o toobar na tela preço
        setSupportActionBar(toolbar)

        //Código que habilita o toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        val edtPrecoCombustivel = findViewById<EditText>(R.id.edtPrecoCombust)
        val btnPrecoCombustivelProximo = findViewById<Button>(R.id.btnPrecoCombustProximo)

            //Click no botão
        btnPrecoCombustivelProximo.setOnClickListener {
            //Ação no botão
            val edtPrecoCombustivelValor = edtPrecoCombustivel.text.toString().toDouble()

            //Intenção de ir para próxima tela
            val intent = Intent(this, ConsumoPorLitroActivity::class.java)

            //colocando Extras pela intent
            intent.putExtra("PRECO LITRO", edtPrecoCombustivelValor)


            //Passando para próxima tela
           startActivity(intent)




        }

    }
    //implementar a função volta para o toolbar

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)

        }

    }
}