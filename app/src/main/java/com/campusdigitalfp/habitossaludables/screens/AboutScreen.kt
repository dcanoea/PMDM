package com.campusdigitalfp.habitossaludables.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.habitossaludables.R

@Composable
fun AboutScreen(navController: NavHostController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.estilo_de_vida),
                contentDescription = "Logo de la aplicación",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Hábitos saludables",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Versión: 1.0.0",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Habitos Saludables es una aplicación que te ayudará a llevar un estilo de vida saludable a través del seguimiento de hábitos diarios como la hidratación, la actividad física y el descanso.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Justify // Alinea el texto al centro
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Desarrollado por Esther Agulló",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { // Establece el valor de "key_result" en el savedStateHandle de la entrada anterior en la pila de navegación. Esto permite enviar datos de la pantalla actual a la pantalla anterior cuando se retrocede en la navegación.
                    navController.previousBackStackEntry?.savedStateHandle?.set("key_result", "Hacer click en volver")
                    navController.popBackStack()},
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(text = "Volver")
            }
        }
    }
}