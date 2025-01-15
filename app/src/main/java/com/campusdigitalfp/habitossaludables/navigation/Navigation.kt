package com.campusdigitalfp.habitossaludables.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.campusdigitalfp.habitossaludables.sampledata.SampleData
import com.campusdigitalfp.habitossaludables.screens.AboutScreen
import com.campusdigitalfp.habitossaludables.screens.EditHabitScreen
import com.campusdigitalfp.habitossaludables.screens.HabitListScreen
import com.campusdigitalfp.habitossaludables.screens.HabitScreen
import com.campusdigitalfp.habitossaludables.screens.NewHabitScreen

enum class NavRoutes (val abreviatura : String) {
    List ("list"),
    About ("about"),
    DetailsFull ("details/{habitoId}"),
    Details("details/"),
    New ("new"),
    EditFull ("edit/{habitoId}"),
    Edit("edit/"),
}

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.List.abreviatura){
        composable(NavRoutes.List.abreviatura) { HabitListScreen(navController) }
        composable(NavRoutes.About.abreviatura) { AboutScreen(navController) }
        composable(NavRoutes.DetailsFull.abreviatura) { backStackEntry ->
            val habitoId = backStackEntry.arguments?.getString("habitoId")?.toIntOrNull()
            //Buscamos el hábito con el id pasado en la ruta
            val habito = SampleData.habitSample.find { it.id == habitoId }

            // Verifica si "habito" no es nulo antes de ejecutar el bloque de código
            habito?.let {
                HabitScreen(navController, it)
            }
        }
        composable(NavRoutes.EditFull.abreviatura) { backStackEntry ->
            val habitoId = backStackEntry.arguments?.getString("habitoId")?.toIntOrNull()
            //Buscamos el hábito con el id pasado en la ruta
            val habito = SampleData.habitSample.find { it.id == habitoId }

            // Verifica si "habito" no es nulo antes de ejecutar el bloque de código
            habito?.let {
                EditHabitScreen(navController, it)
            }
        }
        composable(NavRoutes.New.abreviatura){ NewHabitScreen(navController) }
    }
}