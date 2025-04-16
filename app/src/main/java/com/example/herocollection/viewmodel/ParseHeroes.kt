package com.example.herocollection.viewmodel
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.database.SuperheroDatabase
import com.example.herocollection.model.RetrofitInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class ParseHeroes(private val context: Context) {

    val api_key = "6d2959a734af0710eec6d1f795994fef"


    val driver = AndroidSqliteDriver(
        schema = SuperheroDatabase.Schema,
        context = context,
        name = "superhero.db"
    )
    val database = SuperheroDatabase(driver)


   @SuppressLint("SuspiciousIndentation")
   suspend fun parseHeroes() {
        val retrofit2 = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://superheroapi.com/")
            .build()


        val apiService = retrofit2.create(RetrofitInterface::class.java)
            try {
                for (id in 1..amountOfHeroes) {
                    val hero = apiService.getHeroById(api_key, id)
                    database.superheroQueries.insertOrReplaceHero(
                        id = hero.id,
                        nickname = hero.name,
                        realName = hero.biography.fullName ,
                        description = Json.encodeToString(hero.appearance),
                        imageUrl = hero.image.url,
                        studio = hero.biography.publisher,
                        isFavorite = false,
                        studioLogo = Logos.getLogo(hero.biography.publisher)
                    )
                }
                Log.d("Parse", "Парсинг завершен")
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("АНВАК", "")

                }
            }

    }
}