package com.example.windows.teste.scenarios.scenario_opcao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.windows.teste.R
import com.example.windows.teste.R.id.*
import com.example.windows.teste.entities.Drink
import com.example.windows.teste.scenarios.scenario_busca.busca
import com.example.windows.teste.scenarios.scenario_infoDrink.InfoDrink
import com.example.windows.teste.scenarios.scenario_main.MainActivity
import kotlinx.android.synthetic.main.activity_opcao.*

class opcao : AppCompatActivity(), opcaoContract.view {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcao)

        link_lista.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        link_sortear.setOnClickListener{
            val presenter: opcaoContract.presenter = opcaoPresenter(this)
            presenter.onLoadRandomInfo()
        }

    }

    override fun onResume() {
        super.onResume()

        btn_busca.setOnClickListener{
            val intent = Intent(this, busca::class.java)
            var editText = findViewById<View>(R.id.et_nomeDrink) as EditText
            val nome_drink = editText.text.toString()
            intent.putExtra("nome_drink", nome_drink)
            startActivity(intent)
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    override fun mostraInfo(drink: Drink){
        val intent = Intent(this, InfoDrink::class.java)
        intent.putExtra("drink", drink)
        startActivity(intent)
    }

    override fun showProgressBar() {
        ProgressBar2.visibility = android.widget.ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        ProgressBar2.visibility = android.widget.ProgressBar.INVISIBLE
    }
}
