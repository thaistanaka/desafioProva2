package com.example.windows.teste.scenarios.scenario_main

import com.example.windows.teste.entities.Drink

interface MainContract {

    interface view{
        fun showMessage(message: String)
        fun showList(drinks : List<Drink>)
        fun showProgressBar()
        fun hideProgressBar()
        fun mostraInfo(drink: Drink)
    }

    interface presenter{
        fun onLoadAlcool()
        fun onLoadDrink(drink : Drink)
    }
}