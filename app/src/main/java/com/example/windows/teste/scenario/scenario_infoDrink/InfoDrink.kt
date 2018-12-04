package com.example.windows.teste.scenario.scenario_infoDrink

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.windows.teste.R
import com.example.windows.teste.entitie.Drink
import kotlinx.android.synthetic.main.activity_info_drink.*
import kotlinx.android.synthetic.main.activity_main.*

class InfoDrink : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_drink)

        if(intent.extras != null){
            val drink = intent.getSerializableExtra("drink") as Drink

            mostraInfo(drink)
        }

    }

    fun mostraInfo(drink: Drink) {

            Glide.with(this)
                    .load(drink.strDrinkThumb)
                    .apply(RequestOptions()
                            .placeholder(R.mipmap.ic_launcher))
                    .into(tv_imagedrinkInfo)

            tv_nomedrinkInfo.text = drink.strDrink
            tv_desc.text = drink.strInstructions
            tv_ing1.text = drink.strIngredient1
            tv_ing2.text = drink.strIngredient2
            tv_ing3.text = drink.strIngredient3
            tv_ing4.text = drink.strIngredient4
            tv_ing5.text = drink.strIngredient5
            tv_ing6.text = drink.strIngredient6
            tv_ing7.text = drink.strIngredient7
            tv_ing8.text = drink.strIngredient8
            tv_ing9.text = drink.strIngredient9
            tv_ing10.text = drink.strIngredient10
            tv_ing11.text = drink.strIngredient11
            tv_ing12.text = drink.strIngredient12
            tv_ing13.text = drink.strIngredient13
            tv_ing14.text = drink.strIngredient14
            tv_ing15.text = drink.strIngredient15
            tv_med1.text = drink.strMeasure1
            tv_med2.text = drink.strMeasure2
            tv_med3.text = drink.strMeasure3
            tv_med4.text = drink.strMeasure4
            tv_med5.text = drink.strMeasure5
            tv_med6.text = drink.strMeasure6
            tv_med7.text = drink.strMeasure7
            tv_med8.text = drink.strMeasure8
            tv_med9.text = drink.strMeasure9
            tv_med10.text = drink.strMeasure10
            tv_med11.text = drink.strMeasure11
            tv_med12.text = drink.strMeasure12
            tv_med13.text = drink.strMeasure13
            tv_med14.text = drink.strMeasure14
            tv_med15.text = drink.strMeasure15

    }
}
