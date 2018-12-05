package com.example.windows.teste.scenarios.scenario_busca

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.windows.teste.R
import com.example.windows.teste.R.id.btn_back3
import com.example.windows.teste.R.id.btn_busca2
import com.example.windows.teste.entities.Drink
import com.example.windows.teste.entities.DrinkAdapter
import com.example.windows.teste.scenarios.scenario_infoDrink.InfoDrink
import com.example.windows.teste.scenarios.scenario_opcao.opcao
import kotlinx.android.synthetic.main.activity_busca.*
import kotlinx.android.synthetic.main.activity_main.*

class busca : AppCompatActivity(), buscaContract.view {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca)

        val presenter: buscaContract.presenter = buscaPresenter(this)

        if(intent.extras != null){
            val nome_drink = intent.getStringExtra("nome_drink") as String

            presenter.onLoadNomeDrink(nome_drink)
        }

        btn_back3.setOnClickListener{
            volta()
        }


    }

    override fun onResume() {
        super.onResume()

        btn_busca2.setOnClickListener{
            val intent = Intent(this, busca::class.java)
            var editText = findViewById<View>(R.id.et_nomeDrink2) as EditText
            val nome_drink = editText.text.toString()
            intent.putExtra("nome_drink", nome_drink)
            startActivity(intent)
        }
    }

    override fun showList(drinks: List<Drink>){
        val adapter = DrinkAdapter(this, drinks)
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this,layoutManager.orientation)

        adapter.setOnItemClickListener {position->
            val presenter : buscaContract.presenter = buscaPresenter(this)
            presenter.onLoadDrink(drinks[position])
        }

        rvdrink_alcoolicos.adapter = adapter
        rvdrink_alcoolicos.layoutManager = layoutManager
        rvdrink_alcoolicos.addItemDecoration(dividerItemDecoration)
    }

    override fun mostraInfo(drink: Drink) {
        val intent = Intent(this, InfoDrink::class.java)
        intent.putExtra("drink", drink)
        startActivity(intent)
    }

    override fun hideProgressBar() {
        ProgressBar.visibility = android.widget.ProgressBar.INVISIBLE
    }

    override fun showProgressBar() {
        ProgressBar.visibility = android.widget.ProgressBar.VISIBLE
    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    override fun volta(){
        val intent = Intent(this, opcao::class.java)
        startActivity(intent)
    }


}
