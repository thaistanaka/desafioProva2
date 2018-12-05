package com.example.windows.teste.scenario.scenario_opcao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.windows.teste.R
import com.example.windows.teste.entities.Drink
import com.example.windows.teste.scenario.scenario_infoDrink.InfoDrink
import com.example.windows.teste.scenario.scenario_main.MainActivity
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
