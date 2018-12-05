package com.example.windows.teste.scenarios.scenario_infoDrink

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.windows.teste.R
import com.example.windows.teste.entities.Drink
import com.example.windows.teste.scenarios.scenario_opcao.opcao
import kotlinx.android.synthetic.main.activity_info_drink.*

class InfoDrink : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_drink)

        if(intent.extras != null){
            val drink = intent.getSerializableExtra("drink") as Drink

            mostraInfo(drink)
        }

        btn_back.setOnClickListener{
            val intent = Intent(this, opcao::class.java)
            startActivity(intent)
        }

    }

    private fun showProgressBar() {
        ProgressBar3.visibility = android.widget.ProgressBar.VISIBLE
    }

    private fun hideProgressBar() {
        ProgressBar3.visibility = android.widget.ProgressBar.INVISIBLE
    }

    private fun mostraInfo(drink: Drink) {
            showProgressBar()
            Glide.with(this)
                    .load(drink.strDrinkThumb)
                    .apply(RequestOptions()
                            .placeholder(R.mipmap.ic_launcher))
                    .into(tv_imagedrinkInfo)
            hideProgressBar()

            tv_nomedrinkInfo.text = drink.strDrink
            tv_desc.text = drink.strInstructions
            tv_alcool.text = drink.strAlcoholic
            tv_glass.text = drink.strGlass
            tv_category.text = drink.strCategory

        if(drink.strIngredient1 != "")
        {
            tv_ing1.text = drink.strIngredient1
            tv_med1.text = drink.strMeasure1
            tv1.visibility = View.VISIBLE
        }
        if(drink.strIngredient2 != "")
        {
            tv_ing2.text = drink.strIngredient2
            tv_med2.text = drink.strMeasure2
            tv2.visibility = View.VISIBLE
        }
        if(drink.strIngredient3 != "")
        {
            tv_ing3.text = drink.strIngredient3
            tv_med3.text = drink.strMeasure3
            tv3.visibility = View.VISIBLE
        }
        if(drink.strIngredient4 != "")
        {
            tv_ing4.text = drink.strIngredient4
            tv_med4.text = drink.strMeasure4
            tv4.visibility = View.VISIBLE
        }
        if(drink.strIngredient5 != "")
        {
            tv_ing5.text = drink.strIngredient5
            tv_med5.text = drink.strMeasure5
            tv5.visibility = View.VISIBLE
        }
        if(drink.strIngredient6 != "")
        {
            tv_ing6.text = drink.strIngredient6
            tv_med6.text = drink.strMeasure6
            tv6.visibility = View.VISIBLE
        }
        if(drink.strIngredient7 != "")
        {
            tv_ing7.text = drink.strIngredient7
            tv_med7.text = drink.strMeasure7
            tv7.visibility = View.VISIBLE
        }
        if(drink.strIngredient8 != "")
        {
            tv_ing8.text = drink.strIngredient8
            tv_med8.text = drink.strMeasure8
            tv8.visibility = View.VISIBLE
        }
        if(drink.strIngredient9 != "")
        {
            tv_ing9.text = drink.strIngredient9
            tv_med9.text = drink.strMeasure9
            tv9.visibility = View.VISIBLE
        }
        if(drink.strIngredient10 != "")
        {
            tv_ing10.text = drink.strIngredient10
            tv_med10.text = drink.strMeasure10
            tv10.visibility = View.VISIBLE
        }
        if(drink.strIngredient11 != "")
        {
            tv_ing11.text = drink.strIngredient11
            tv_med11.text = drink.strMeasure11
            tv11.visibility = View.VISIBLE
        }
        if(drink.strIngredient12 != "")
        {
            tv_ing12.text = drink.strIngredient12
            tv_med12.text = drink.strMeasure12
            tv12.visibility = View.VISIBLE
        }
        if(drink.strIngredient13 != "")
        {
            tv_ing13.text = drink.strIngredient13
            tv_med13.text = drink.strMeasure13
            tv13.visibility = View.VISIBLE
        }
        if(drink.strIngredient14 != "")
        {
            tv_ing14.text = drink.strIngredient14
            tv_med14.text = drink.strMeasure14
            tv14.visibility = View.VISIBLE
        }
        if(drink.strIngredient15 != "")
        {
            tv_ing15.text = drink.strIngredient15
            tv_med15.text = drink.strMeasure15
            tv15.visibility = View.VISIBLE
        }

    }
}
