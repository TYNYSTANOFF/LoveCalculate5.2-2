package com.example.lovecalculate52_2.model

import com.example.lovecalculate52_2.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

//    https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John

//    "X-RapidAPI-Key", "c1ce281922mshc88127904e9fac7p1725b1jsn9e2910845d9c"
//    "X-RapidAPI-Host", "love-calculator.p.rapidapi.com"


   @GET("getPercentage")
    fun getPercentage(
       @Query("fname") firstName : String,
       @Query("sname") secondName : String,
       @Header("X-RapidAPI-Key") key:String = "c1ce281922mshc88127904e9fac7p1725b1jsn9e2910845d9c",
   @Header("X-RapidAPI-Host") host:String = "love-calculator.p.rapidapi.com"
    ) : Call<LoveModel>


}