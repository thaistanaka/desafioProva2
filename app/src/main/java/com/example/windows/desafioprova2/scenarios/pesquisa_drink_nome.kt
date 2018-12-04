package com.example.windows.desafioprova2.scenarios

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.example.windows.desafioprova2.R
import com.example.windows.desafioprova2.entities.Drink
import kotlinx.android.synthetic.main.activity_pesquisa_drink_nome.*

class pesquisa_drink_nome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa_drink_nome)

        pesquisa_nome()

        btn_back.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
    }

    fun pesquisa_nome(){
        var pesquisa_drink = findViewById<View>(R.id.pesquisa_drink2) as EditText
        val nome_drink = pesquisa_drink.text.toString()

        btn_pesquisa2.setOnClickListener {
            val intent = Intent(this, pesquisa_drink_nome::class.java)
            startActivity(intent)
        }
    }
}
