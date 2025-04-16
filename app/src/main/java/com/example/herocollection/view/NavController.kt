package com.example.herocollection.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.herocollection.viewmodel.MainVM

@Composable
fun AppNavigation(viewModel: MainVM = viewModel()){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "allHero") {

        composable("allHero") {
            MailScreen(navController = navController,
                    viewModel = viewModel,)
        }


        composable("hero_details/{heroId}") { backStackEntry ->
            val heroId = backStackEntry.arguments?.getString("heroId")
            heroId?.let {
                HeroDetail(navController = navController,heroId = it, viewModel = viewModel)


            }
        }
    }
}
