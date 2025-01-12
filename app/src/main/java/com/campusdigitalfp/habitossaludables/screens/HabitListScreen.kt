package com.campusdigitalfp.habitossaludables.screens

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.habitossaludables.R
import com.campusdigitalfp.habitossaludables.sampledata.SampleData
import com.campusdigitalfp.habitossaludables.ui.theme.HabitosSaludablesTheme

@Composable
fun HabitListScreen(navController: NavHostController) {
    // Obtiene el savedStateHandle de la entrada actual en la pila de navegación del NavController
    val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
    // Verifica si el savedStateHandle no es nulo antes de continuar
    if (savedStateHandle != null) {
        // Obtiene el contexto actual necesario para mostrar un Toast
        val context = LocalContext.current

        // Define una variable "result" que observa un LiveData llamado "key_result" almacenado en savedStateHandle
        // Con observeAsState(), se convierte el LiveData en un estado observable por Compose
        val result by savedStateHandle.getLiveData<String>("key_result").observeAsState()

        // Usa let para ejecutar un bloque solo si "result" no es nulo
        result.let {
            // LaunchedEffect ejecuta el bloque cada vez que "result" cambia
            LaunchedEffect(it) {
                // Si el valor de "result" no es nulo, muestra un Toast con el valor de "result"
                if (it != null)
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
    HabitosSaludablesTheme {
        Scaffold { paddingValues ->
            Column {
                VistaListaHabitos(SampleData.habitSample, paddingValues = paddingValues, navController = navController)

                Button(onClick = { navController.navigate("about") }) {
                    Text("Acerca de")
                }
            }
        }
    }
}

data class Habito(val id: Int, val titulo: String, val descripcion: String)

@Composable
fun VistaHabito(habito: Habito, onClick: () -> Unit) {
    Row(modifier = Modifier.padding(all = 8.dp).clickable(onClick = onClick)) {
        Image(
            painter = painterResource(id = R.drawable.estilo_de_vida),
            contentDescription = "Icono estilo de vida",
            modifier = Modifier.size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)

        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            label = "AnimacionDeColor",
        )

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = habito.titulo,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.width(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = habito.descripcion,
                    modifier = Modifier.padding(4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun VistaListaHabitos(habitos: List<Habito>, paddingValues: PaddingValues, navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f) // Ocupa el espacio disponible, excepto lo que necesita IrAcercaDe
                .padding(16.dp)
        ) {
            items(habitos) { habito ->
                VistaHabito(habito, onClick = {
                    navController.navigate("details/${habito.id}")
                })
            }
        }

        IrAcercaDe(navController = navController)
    }
}

@Composable
fun IrAcercaDe(navController: NavHostController){
    Button(onClick = { navController.navigate("about") }) {
        Text("Acerca de")
    }
}



