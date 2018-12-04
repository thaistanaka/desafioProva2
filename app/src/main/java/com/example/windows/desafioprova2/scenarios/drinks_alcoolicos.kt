package com.example.windows.desafioprova2.scenarios

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.windows.desafioprova2.R
import com.example.windows.desafioprova2.entities.Drink
import com.example.windows.desafioprova2.network.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_drinks_alcoolicos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class drinks_alcoolicos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks_alcoolicos)

        btn_back_alc.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        val call = RetrofitInitializer().drinkService().list()

        call.enqueue(object: Callback<List<Drink>?> {
            override fun onResponse(call: Call<List<Drink>?>?,
                                    response: Response<List<Drink>?>?){
                response?.body()?.let {
                    val drinks: List<Drink> = it
                    configureList(drinks)
                }
            }

            override fun onFailure(call: Call<List<Drink>?>?,
                                   throwable: Throwable?){
                Log.e("onFailure error", throwable?.message)
            }
        }


        )

    }

    private fun configureList(drinks: List<Drink>){
        val recyclerView = rvdrink_alcoolicos
        recyclerView.adapter = DrinkAdapter(this, drinks)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }


}


