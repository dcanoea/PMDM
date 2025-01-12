package com.campusdigitalfp.habitossaludables.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun BarraSuperiorComun(navController: NavHostController, atras: Boolean = true) {
    TopAppBar(
        // Definimos los colores personalizados para la TopAppBar
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer, // Color de fondo de la barra
            titleContentColor = MaterialTheme.colorScheme.primary, // Color del título
        ),
        title = {
            Text(text = "Hábitos Saludables")
        },
        navigationIcon = {
            if (atras) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Atrás"
                    )
                }
            }
        },
                //Icono de añadir nuevo hábito
                actions = {
            if (!atras) { //Para que solo se muestre cuando no se muestra el botón de ir atrás
                IconButton(onClick = { navController.navigate("new") }) { //El botón navegará a la nueva pantalla
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Añadir nuevo hábito."
                    )
                }
            }
        }
    )
}