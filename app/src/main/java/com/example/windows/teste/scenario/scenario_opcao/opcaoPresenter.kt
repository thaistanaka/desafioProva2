package com.example.windows.teste.scenario.scenario_opcao

import com.example.windows.teste.entities.DrinkList
import com.example.windows.teste.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class opcaoPresenter(val view: opcaoContract.view): opcaoContract.presenter {
    override fun onLoadRandomInfo(){
        view.showProgressBar()
        val callRandom = RetrofitInicializer().drinkService().random()

        callRandom.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideProgressBar()
                view.showMessage("Connection failed")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideProgressBar()
                if (response.body() != null){
                    view.mostraInfo(response.body()!!.drinks[0])
                }else{
                    view.showMessage("No Drinks")
                }
            }

        })
    }
}