package com.example.windows.desafioprova2.scenarios_main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.windows.desafioprova2.R
import kotlinx.android.synthetic.main.activity_drinks_alcoolicos.*

class drinks_alcoolicos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks_alcoolicos)

        btn_back_alc.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
    }

}
