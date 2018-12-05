package com.example.windows.teste.scenarios.scenario_opcao

import com.example.windows.teste.entities.Drink

interface opcaoContract {

    interface view{
        fun showProgressBar()
        fun hideProgressBar()
        fun showMessage(message: String)
        fun mostraInfo(drink: Drink)
    }

    interface presenter{
        fun onLoadRandomInfo()
    }
}