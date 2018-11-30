package com.example.windows.desafioprova2.scenarios_main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.windows.desafioprova2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val home = Intent(this, home::class.java)
            startActivity(home)
            finish()
        },2000)
    }

}
