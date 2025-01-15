package com.campusdigitalfp.habitossaludables.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.habitossaludables.R
import com.campusdigitalfp.habitossaludables.common.BarraSuperiorComun
import com.campusdigitalfp.habitossaludables.common.Habito
import com.campusdigitalfp.habitossaludables.ui.theme.HabitosSaludablesTheme

@Composable
fun EditHabitScreen(navController: NavHostController, habito: Habito) {
    val context = LocalContext.current
    val cancelButtonBackground = Color(0xFFEEEEEE)
    val cancelButtonText = Color(0xFF757575)

    val saveButtonBackground = Color(0xFFA5D6A7)
    val saveButtonText = Color(0xFF388E3C)

    var titulo by remember { mutableStateOf(habito.titulo) }
    var descripcion by remember { mutableStateOf(habito.descripcion) }

    HabitosSaludablesTheme {
    Scaffold (topBar = { BarraSuperiorComun(navController) }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Text(
                text = "Editando Hábito " + habito.titulo,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            TextField(
                value = titulo,
                onValueChange = { newText -> titulo = newText },
                label = { Text(stringResource(R.string.t_tulo_del_h_bito)) },
                placeholder = { Text(stringResource(R.string.t_tulo_del_h_bito)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Sentences
                )
            )

            TextField(
                value = descripcion,
                onValueChange = { newText -> descripcion = newText },
                label = { Text(stringResource(R.string.descripci_n_del_h_bito)) },
                placeholder = { Text(stringResource(R.string.descripci_n_del_h_bito)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = false,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Sentences
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(
                    onClick = {
                        navController.previousBackStackEntry?.savedStateHandle?.set("key_result",
                            context.getString(
                                R.string.operaci_n_cancelada
                            ))
                        navController.popBackStack()
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = cancelButtonBackground),
                    border = BorderStroke(1.dp, cancelButtonText)
                ) {
                    Text(text = stringResource(R.string.cancelar), color = cancelButtonText)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        habito.titulo = titulo
                        habito.descripcion = descripcion
                        navController.previousBackStackEntry?.savedStateHandle?.set("key_result","Habito modificado con éxito")
                        navController.popBackStack()
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = saveButtonBackground),
                    border = BorderStroke(1.dp, saveButtonText)
                ) {
                    Text(text = stringResource(R.string.guardar), color = saveButtonText)
                }
            }
        }
    }
}
}
