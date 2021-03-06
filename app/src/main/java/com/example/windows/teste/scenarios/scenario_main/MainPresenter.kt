package com.example.windows.teste.scenarios.scenario_main

import com.example.windows.teste.entities.Drink
import com.example.windows.teste.entities.DrinkList
import com.example.windows.teste.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.view): MainContract.presenter {


    override fun onLoadAlcool(){

        view.showProgressBar()
        val call = RetrofitInicializer().drinkService().list()

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideProgressBar()
                view.showMessage("Connection failed")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideProgressBar()
                if (response.body() != null){
                    view.showList(response.body()!!.drinks)
                }else{
                    view.showMessage("No drinks")
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
                if(response.body() != null){
                    view.mostraInfo(response.body()!!.drinks[0])
                }else {
                    view.showMessage("No Drinks")
                }
            }
        })
    }

}