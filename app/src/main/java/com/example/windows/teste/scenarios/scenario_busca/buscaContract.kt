package com.example.windows.teste.scenarios.scenario_busca

import com.example.windows.teste.entities.Drink


interface buscaContract {
    interface view{
        fun hideProgressBar()
        fun showProgressBar()
        fun showList(drinks: List<Drink>)
        fun showMessage(message: String)
        fun mostraInfo(drink: Drink)
        fun volta()
    }

    interface presenter{
        fun onLoadNomeDrink(nome_drink : String)
        fun onLoadDrink(drink: Drink)
    }
}