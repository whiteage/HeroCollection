package com.example.herocollection.viewmodel

import com.example.database.Superhero

data class Uistate(
    val heroes : List<Superhero> = emptyList(),
    var chosenHeroes : List<Superhero> = emptyList(),

)

