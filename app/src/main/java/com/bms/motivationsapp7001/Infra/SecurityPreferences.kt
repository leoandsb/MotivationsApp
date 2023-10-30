package com.bms.motivationsapp7001.Infra

import android.content.Context

class SecurityPreferences(context: Context) {


   private val sharedPreferences=context.
    getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun addString(chave:String,valor:String){
        sharedPreferences.edit().putString(chave,valor).apply()
    }

    fun getString(chave:String):String{
       return sharedPreferences.getString(chave,"")?:""
    }


}