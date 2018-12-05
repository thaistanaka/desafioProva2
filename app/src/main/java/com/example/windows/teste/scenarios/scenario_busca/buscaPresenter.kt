package com.example.windows.teste.scenarios.scenario_busca

import com.example.windows.teste.entities.Drink
import com.example.windows.teste.entities.DrinkList
import com.example.windows.teste.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class buscaPresenter (val view: buscaContract.view): buscaContract.presenter{
    override fun onLoadNomeDrink(nome_drink: String){
            view.showProgressBar()
            val call = RetrofitInicializer().drinkService().busca(nome_drink)

            call.enqueue(object : Callback<DrinkList> {
                override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                    view.hideProgressBar()
                    view.showMessage("Connection failed")
                }

                override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                    view.hideProgressBar()
                    if(response.body() != null){
                        view.showList(response.body()!!.drinks)
                    }else {
                        view.showMessage("No Drinks")
                    }
                }
            })

    }

    override fun onLoadDrink(drink: Drink) {
        view.showProgressBar()
        val call = RetrofitInicializer().drinkService().id_drink(drink.idDrink)

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideProgressBar()
                view.showMessage("Connection failed")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideProgressBar()
                if (response.body() != null) {
                    view.mostraInfo(response.body()!!.drinks[0])
                } else {
                    view.showMessage("No Drinks")
                }
            }
        })

    }
}