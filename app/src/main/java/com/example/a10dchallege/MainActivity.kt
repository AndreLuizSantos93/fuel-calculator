package com.example.a10dchallege

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtResultado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // recuperar as views pelo findViewById
        val btnCalcular = findViewById<Button>(R.id.btnMainProximo)

        //Colocar ação no botão
        btnCalcular.setOnClickListener {
            // Nevegar para a próxima tela.


            // intent = Intent(this, telaDesejada::class.java) intenção de navegar para a próxima tela
            val intent = Intent(this, precoActivity::class.java)

            //passa para função start para qual tela tem a intenção de navegar
            startActivity(intent)


        }
    }
}