package com.example.windows.desafioprova2.scenarios_main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import com.example.windows.desafioprova2.R
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        pesquisa_nome()

        lista_drink.setOnClickListener {
            val intent = Intent(this, drinks_alcoolicos::class.java)
            startActivity(intent)
        }

        sortear.setOnClickListener {
            val intent = Intent(this, drink_descricao::class.java)
            startActivity(intent)
        }
    }

    fun pesquisa_nome(){
        var pesquisa_drink = findViewById<View>(R.id.pesquisa_drink) as EditText
        val nome_drink = pesquisa_drink.text.toString()

        btn_pesquisa.setOnClickListener {
            val intent = Intent(this, pesquisa_drink_nome::class.java)
            startActivity(intent)
        }
    }


}
