package com.bms.motivationsapp7001

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bms.motivationsapp7001.Infra.FrasesActivity
import com.bms.motivationsapp7001.Infra.SecurityPreferences
import com.bms.motivationsapp7001.databinding.ActivityMainBinding
import com.bms.motivationsapp7001.util.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        securityPreferences = SecurityPreferences(this)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.btnContinuar.setOnClickListener {
            salvarNome()
        }
        verificarNome()

    }

    private fun verificarNome() {
        val nome = securityPreferences.getString(Constants.nome)
        val pFrases = Intent(this,FrasesActivity::class.java)
        if  (nome != "")
            startActivity(pFrases)
    }

    private fun salvarNome() {
    val nome = binding.txtiNome.text.toString()
        val pFrases = Intent(this,FrasesActivity::class.java)

    if (nome!=""){
        securityPreferences.addString(Constants.nome,nome)
        Toast.makeText(this,"Nome inserido",Toast.LENGTH_SHORT).show()
        startActivity(pFrases)
        finish()
    } else {
        Toast.makeText(this,"Preencha as informações primeiro",Toast.LENGTH_SHORT).show()
    }
    }
}