package com.example.windows.teste.scenarios.scenario_main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.windows.teste.R
import com.example.windows.teste.entities.Drink
import com.example.windows.teste.entities.DrinkAdapter
import com.example.windows.teste.scenarios.scenario_infoDrink.InfoDrink
import com.example.windows.teste.scenarios.scenario_opcao.opcao
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.view {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.presenter = MainPresenter(this)
        presenter.onLoadAlcool()

        btn_back2.setOnClickListener{
            val intent = Intent(this, opcao::class.java)
            startActivity(intent)
        }

    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    override fun showList(drinks: List<Drink>) {
        val adapter = DrinkAdapter(this, drinks)
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this,layoutManager.orientation)

        adapter.setOnItemClickListener {position->
            val presenter : MainContract.presenter = MainPresenter(this)
            presenter.onLoadDrink(drinks[position])
        }

        rvdrink_alcoolicos.adapter = adapter
        rvdrink_alcoolicos.layoutManager = layoutManager
        rvdrink_alcoolicos.addItemDecoration(dividerItemDecoration)
    }

    override fun mostraInfo(drink: Drink){
        val intent = Intent(this, InfoDrink::class.java)
        intent.putExtra("drink", drink)
        startActivity(intent)
    }

    override fun showProgressBar() {
        ProgressBar.visibility = android.widget.ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        ProgressBar.visibility = android.widget.ProgressBar.INVISIBLE
    }

}
