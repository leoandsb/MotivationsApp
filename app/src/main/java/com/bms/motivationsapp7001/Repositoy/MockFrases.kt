package com.bms.motivationsapp7001.Repositoy

import android.util.Log
import com.bms.motivationsapp7001.util.Constants
import kotlin.random.Random

class MockFrases {

    private val todas = Constants.todas
    private val positivas = Constants.positivas
    private val dia = Constants.dia

    private val mapFrases = mutableMapOf(
        positivas to mutableListOf(
            "Mesmo que pareça difícil, não pare!",
            "Só trabalhando é possível trilhar o caminho!",
            "Descubra quem você realmente é…",
            "Não espere que as respostas caiam do céu!",
            "Aprenda a lidar com as situações do melhor jeito!",
            "Veja sempre o que há de positivo nas coisas!",
        ),
        dia to mutableListOf(
            "A cada manhã o mundo é novo para mim.",
            "Nem todos os dias são fáceis, mas entregá-los todas as manhãs a Deus me faz ter a certeza de que Ele está no controle de tudo. Bom dia!",
            "Por que esta manhã tem que começar tão cedo? Preciso de mais tempo para sonhar com você!",
            "Não importa a cor do céu. Quem faz o dia bonito é você.",
            "Espero que sua manhã seja tão linda e brilhante quanto seu sorriso.",
            "Tenha um dia abençoado e agradeça a Deus todas as dádivas que Ele coloca no seu caminho.",
        )
    )

    var valoresFrases = mutableListOf<String>()

    fun getList(){
        for (item in mapFrases){
            valoresFrases += item.value
        }
    }

    init {
        getList()
        Log.d("Listona", valoresFrases.toString())
    }

    fun getFrases (filtro:Int):String{
        val random:Int

        return if(filtro != todas){
            val frasesFiltradas = mapFrases.getValue(filtro)
            random = Random.nextInt(frasesFiltradas.size)
            frasesFiltradas[random]

        } else {
            random = Random.nextInt(valoresFrases.size)
            valoresFrases[random]
        }
    }
}