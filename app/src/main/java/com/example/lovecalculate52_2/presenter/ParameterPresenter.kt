package com.example.lovecalculate52_2.presenter

import android.util.Log
import com.example.lovecalculate52_2.App
import com.example.lovecalculate52_2.model.LoveApi
import com.example.lovecalculate52_2.model.LoveModel
import com.example.lovecalculate52_2.model.room.LoveDao
import com.example.lovecalculate52_2.view.views.ParameterView
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ParameterPresenter @Inject constructor(private val api:LoveApi, private val dao:LoveDao){
    lateinit var view: ParameterView
    val TAG = "ololo"


    fun attachView(view: ParameterView) {
        this.view = view
    }

    fun getData(firstName: String, secondName: String) {
        api.getPercentage(firstName, secondName).enqueue(object : retrofit2.Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    val model = response.body()
                    model?.let {
                        dao.insert(it)
                        view.changeScreen(it)
                    }

                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })


    }
    //обязательно нужно привязать вьюшки,потом в фрагменте вставляем виев в виев

}