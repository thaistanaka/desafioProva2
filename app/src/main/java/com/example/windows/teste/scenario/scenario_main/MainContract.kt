package com.example.windows.teste.scenario.scenario_main

import com.example.windows.teste.entitie.Drink
import com.example.windows.teste.entitie.DrinkList

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
        fun onLoadRandomInfo()
    }
}