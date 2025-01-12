package com.campusdigitalfp.habitossaludables.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.campusdigitalfp.habitossaludables.sampledata.SampleData
import com.campusdigitalfp.habitossaludables.screens.AboutScreen
import com.campusdigitalfp.habitossaludables.screens.HabitListScreen
import com.campusdigitalfp.habitossaludables.screens.HabitScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list"){
        composable("list") { HabitListScreen(navController) }
        composable("about") { AboutScreen(navController) }
        composable("details/{habitoId}") { backStackEntry ->
            val habitoId = backStackEntry.arguments?.getString("habitoId")?.toIntOrNull()
            //Buscamos el hábito con el id pasado en la ruta
            val habito = SampleData.habitSample.find { it.id == habitoId }

            // Verifica si "habito" no es nulo antes de ejecutar el bloque de código
            habito?.let {
                HabitScreen(navController, it)
            }
        }
    }
}