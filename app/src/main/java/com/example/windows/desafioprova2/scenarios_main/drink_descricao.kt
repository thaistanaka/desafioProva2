package com.example.windows.desafioprova2.scenarios_main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.windows.desafioprova2.R
import kotlinx.android.synthetic.main.activity_drink_descricao.*

class drink_descricao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_descricao)

        btn_back_desc.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
    }
}
