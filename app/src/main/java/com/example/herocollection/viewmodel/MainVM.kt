package com.example.herocollection.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.Superhero
import com.example.herocollection.model.AppearanceDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

const val amountOfHeroes = 24

class MainVM(private val context: Context) : ViewModel() {


    private val _heroes = MutableLiveData<List<Superhero>>()
    private val _hero = MutableLiveData<Superhero>()
    val  superheroes : LiveData<List<Superhero>> = _heroes
    val superhero : LiveData<Superhero> = _hero
    private val _superheroAppearanceDto = MutableLiveData<AppearanceDto>()
    val superheroAppearanceDto : LiveData<AppearanceDto> = _superheroAppearanceDto

    private val _likeB = MutableLiveData<Boolean>()
    val likeB: LiveData<Boolean> = _likeB

    private val _chosenFiltr = MutableLiveData<String>()
    val chosenFiltr: LiveData<String> = _chosenFiltr

    private val parseHeroes = ParseHeroes(context)

    fun loadHeroes(){
        viewModelScope.launch(Dispatchers.IO){

            val heroesList = getHeroesfromDAtaBase()
            if(heroesList.size == amountOfHeroes){
                withContext(Dispatchers.Main) {
                    _heroes.postValue(heroesList)
                }
            }else{
                parseHeroes.parseHeroes()
                val heroesList = getHeroesfromDAtaBase()
                withContext(Dispatchers.Main) {
                    Log.d("MainVM", "Loaded heroes: $heroesList")
                    _heroes.postValue(heroesList)}
            }
            }


        }


    fun setChosenFilter(value: String) {
        _chosenFiltr.postValue(value)
    }

    fun chosenStudio(item: String) {
        val newHeroList =  parseHeroes.database.superheroQueries.selectHeroByStudio(item).executeAsList()
        _heroes.postValue(newHeroList)
    }

    fun getHeroByID(id: String) {
        val hero = parseHeroes.database.superheroQueries.selectHeroById(id).executeAsOne()
        _likeB.postValue(hero.isFavorite!!)
        _hero.postValue(hero)
        getFromDescString(hero)
    }


    fun getFromDescString(item: Superhero){
        val appearance = Json.decodeFromString<AppearanceDto>(item.description ?: "ДАННЫЕ УДАЛЕНЫ")
        _superheroAppearanceDto.postValue(appearance)
    }

    fun chosenOthersStudios() {
        val othersHerosList =  parseHeroes.database.superheroQueries.selectOthersByStudio().executeAsList()
        _heroes.postValue(othersHerosList)
    }




   fun changeFavorite(item: Superhero) {
        val newFavorite = !item.isFavorite!!
        parseHeroes.database.superheroQueries.updateFavorite(newFavorite, item.id)
        val updatedList = parseHeroes.database.superheroQueries.selectAllHeroes().executeAsList()
        getHeroByID(item.id)
        _heroes.postValue(updatedList)

    }


    private suspend fun getHeroesfromDAtaBase() : List<Superhero>{
        return withContext(Dispatchers.IO) {
            parseHeroes.database.superheroQueries.selectAllHeroes().executeAsList()

        }
    }
}

