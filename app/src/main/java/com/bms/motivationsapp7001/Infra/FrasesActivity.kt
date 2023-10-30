package com.bms.motivationsapp7001.Infra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.bms.motivationsapp7001.R
import com.bms.motivationsapp7001.Repositoy.MockFrases
import com.bms.motivationsapp7001.databinding.ActivityFrasesBinding
import com.bms.motivationsapp7001.util.Constants

class FrasesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFrasesBinding
    private lateinit var securityPreferences: SecurityPreferences
    private var filtro = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrasesBinding.inflate(layoutInflater)
        securityPreferences = SecurityPreferences(this)
        setContentView(binding.root)

        val mockFrases = MockFrases()

        val nome = securityPreferences.getString(Constants.nome)
        binding.txtOla.text = "Olá $nome"

        binding.imgTodos.setOnClickListener{
            addFiltro(it.id)
        }
        binding.imgDia.setOnClickListener{
            addFiltro(it.id)
        }
        binding.imgPositivas.setOnClickListener{
            addFiltro(it.id)
        }

        addFiltro(R.id.imgTodos)

        binding.btnGerar.setOnClickListener {
            novaFrase(filtro)
        }

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }

    private fun novaFrase(filtro:Int) {
        val mockFrases = MockFrases()
        val frase = mockFrases.getFrases(filtro)

        binding.editFrases.text = Editable.Factory.getInstance().newEditable(frase)
    }

    private fun addFiltro(id:Int) {
        DrawableCompat.setTint(binding.imgTodos.drawable,
            ContextCompat.getColor(this, R.color.colorAccent))

        DrawableCompat.setTint(binding.imgDia.drawable,
            ContextCompat.getColor(this, R.color.colorAccent))

        DrawableCompat.setTint(binding.imgPositivas.drawable,
            ContextCompat.getColor(this, R.color.colorAccent))

        when(id){
            R.id.imgTodos -> { DrawableCompat.setTint(binding.imgTodos.drawable,
                ContextCompat.getColor(this, R.color.white)) }

            R.id.imgDia -> { DrawableCompat.setTint(binding.imgDia.drawable,
                ContextCompat.getColor(this, R.color.white)) }

            R.id.imgPositivas -> { DrawableCompat.setTint(binding.imgPositivas.drawable,
                ContextCompat.getColor(this, R.color.white)) }
        }
    }
}