package com.example.tareas_desarrollo_apps_moviles

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.tareas_desarrollo_apps_moviles.ui.theme.Tareas_desarrollo_apps_movilesTheme

// ---------- Datos ----------

data class Tarea(
    val titulo: String,
    val descripcion: String,
    val fecha: String
)

val listaTareas = listOf(
    Tarea("Tarea 1: Introducción a Kotlin", "Resolver los ejercicios de variables y funciones.", "05/09/2026"),
    Tarea("Tarea 2: Layouts en Compose", "Crear una pantalla con Column, Row y Box.", "12/09/2026"),
    Tarea("Tarea 3: Estado en Compose", "Implementar un contador con remember y mutableStateOf.", "19/09/2026"),
    Tarea("Tarea 4: Navegación", "Navegar entre dos pantallas usando NavHost.", "26/09/2026"),
    Tarea("Tarea 5: ViewModel", "Separar la lógica de la UI con un ViewModel.", "03/10/2026"),
    Tarea("Tarea 6: Listas", "Mostrar una lista con LazyColumn y cards.", "10/10/2026"),
    Tarea("Tarea 7: Animaciones Lottie", "Integrar dos animaciones de LottieFiles.", "17/10/2026"),
    Tarea("Tarea 8: Intents implícitos", "Llamada, correo, mapa y navegador.", "24/10/2026"),
    Tarea("Tarea 9: Persistencia", "Guardar datos con Room o DataStore.", "31/10/2026"),
    Tarea("Tarea 10: Consumo de API", "Consumir un servicio REST con Retrofit.", "07/11/2026"),
    Tarea("Tarea 11: Permisos", "Solicitar permisos en tiempo de ejecución.", "14/11/2026"),
    Tarea("Tarea 12: Proyecto final", "Entregar la app completa y documentada.", "28/11/2026")
)

// ---------- Constantes de los intents (verifica/ajusta con Google Maps) ----------

private const val NUMERO_EMERGENCIAS = "911"
private const val CORREO_DESTINO = "profesor@morelia.tecnm.mx"
private const val CAMPUS1_LAT = 19.7233   // Latitud aproximada ITM Campus 1
private const val CAMPUS1_LNG = -101.1858 // Longitud aproximada ITM Campus 1
private const val ZOOM_MAPA = 18
private const val URL_INSTITUTO = "https://www.morelia.tecnm.mx"

// ---------- Pantallas disponibles ----------

enum class Pantalla {
    MENU,
    TAREAS,
    ANIMACIONES,
    FUNCIONES
}

// ---------- Activity ----------

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tareas_desarrollo_apps_movilesTheme {
                AppPrincipal()
            }
        }
    }
}

@Composable
fun AppPrincipal() {
    var pantalla by rememberSaveable { mutableStateOf(Pantalla.MENU) }

    // El botón "atrás" del sistema regresa al menú desde cualquier práctica
    BackHandler(enabled = pantalla != Pantalla.MENU) {
        pantalla = Pantalla.MENU
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        when (pantalla) {
            Pantalla.MENU -> PantallaMenu(
                modifier = modifier,
                onElegir = { pantalla = it }
            )
            Pantalla.TAREAS -> PantallaTareas(
                modifier = modifier,
                onVolver = { pantalla = Pantalla.MENU }
            )
            Pantalla.ANIMACIONES -> PantallaAnimaciones(
                modifier = modifier,
                onVolver = { pantalla = Pantalla.MENU }
            )
            Pantalla.FUNCIONES -> PantallaFunciones(
                modifier = modifier,
                onVolver = { pantalla = Pantalla.MENU }
            )
        }
    }
}

// ---------- Helpers para lanzar intents ----------

private fun Context.lanzarIntent(intent: Intent) {
    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(this, "No hay una app disponible para esta acción", Toast.LENGTH_SHORT).show()
    }
}

private fun Context.llamadaEmergencia() {
    // ACTION_DIAL abre el marcador con el número; no requiere permiso CALL_PHONE
    lanzarIntent(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$NUMERO_EMERGENCIAS")))
}

private fun Context.redactarCorreo() {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:") // solo apps de correo
        putExtra(Intent.EXTRA_EMAIL, arrayOf(CORREO_DESTINO))
        putExtra(Intent.EXTRA_SUBJECT, "Entrega de tarea")
        putExtra(Intent.EXTRA_TEXT, "Hola, adjunto la entrega de la tarea.\n\nSaludos.")
    }
    lanzarIntent(intent)
}

private fun Context.abrirMapaCampus() {
    // z = nivel de zoom (1 mundo ... 21 edificios)
    val uri = Uri.parse("geo:$CAMPUS1_LAT,$CAMPUS1_LNG?z=$ZOOM_MAPA")
    lanzarIntent(Intent(Intent.ACTION_VIEW, uri))
}

private fun Context.abrirPaginaInstituto() {
    lanzarIntent(Intent(Intent.ACTION_VIEW, Uri.parse(URL_INSTITUTO)))
}

// ---------- Componentes reutilizables ----------

@Composable
fun Encabezado(titulo: String, onVolver: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(onClick = onVolver) {
            Text("Menú")
        }
        Text(
            text = titulo,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

// ---------- Menú inicial ----------

@Composable
fun PantallaMenu(modifier: Modifier = Modifier, onElegir: (Pantalla) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Prácticas",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Elige la práctica que quieres ver",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { onElegir(Pantalla.TAREAS) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("1. Lista de tareas (LazyColumn + Cards)")
            }
            Button(
                onClick = { onElegir(Pantalla.ANIMACIONES) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("2. Animaciones Lottie")
            }
            Button(
                onClick = { onElegir(Pantalla.FUNCIONES) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("3. Funciones del móvil (Intents)")
            }
        }
    }
}

// ---------- Práctica 1: LazyColumn con cards ----------

@Composable
fun PantallaTareas(modifier: Modifier = Modifier, onVolver: () -> Unit) {
    Column(modifier = modifier.fillMaxSize()) {
        Encabezado(titulo = "Mis tareas", onVolver = onVolver)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(listaTareas) { tarea ->
                TareaCard(tarea)
            }
        }
    }
}

@Composable
fun TareaCard(tarea: Tarea, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = tarea.titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = tarea.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "Fecha: ${tarea.fecha}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

// ---------- Práctica 2: dos animaciones Lottie en una columna ----------

@Composable
fun PantallaAnimaciones(modifier: Modifier = Modifier, onVolver: () -> Unit) {
    val composicion1 by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animacion1))
    val composicion2 by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animacion2))

    Column(modifier = modifier.fillMaxSize()) {
        Encabezado(titulo = "Animaciones Lottie", onVolver = onVolver)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LottieAnimation(
                composition = composicion1,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            LottieAnimation(
                composition = composicion2,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}

// ---------- Práctica 3: intents ----------

@Composable
fun PantallaFunciones(modifier: Modifier = Modifier, onVolver: () -> Unit) {
    val context = LocalContext.current

    Column(modifier = modifier.fillMaxSize()) {
        Encabezado(titulo = "Funciones del móvil", onVolver = onVolver)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(onClick = { context.llamadaEmergencia() }, modifier = Modifier.fillMaxWidth()) {
                Text("Llamada de emergencia")
            }
            Button(onClick = { context.redactarCorreo() }, modifier = Modifier.fillMaxWidth()) {
                Text("Redactar correo electrónico")
            }
            Button(onClick = { context.abrirMapaCampus() }, modifier = Modifier.fillMaxWidth()) {
                Text("Ver Campus 1 en el mapa (zoom)")
            }
            Button(onClick = { context.abrirPaginaInstituto() }, modifier = Modifier.fillMaxWidth()) {
                Text("Abrir página del instituto")
            }
        }
    }
}

// ---------- Previews ----------

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    Tareas_desarrollo_apps_movilesTheme {
        PantallaMenu(onElegir = {})
    }
}

@Preview(showBackground = true)
@Composable
fun TareaCardPreview() {
    Tareas_desarrollo_apps_movilesTheme {
        TareaCard(listaTareas.first())
    }
}
