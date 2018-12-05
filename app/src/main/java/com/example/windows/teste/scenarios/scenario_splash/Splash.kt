package com.example.windows.teste.scenarios.scenario_splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.windows.teste.R
import com.example.windows.teste.scenarios.scenario_opcao.opcao

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, opcao::class.java))
            finish()
        },4000)
    }
}
