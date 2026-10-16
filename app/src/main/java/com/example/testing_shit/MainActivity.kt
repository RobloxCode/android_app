package com.example.testing_shit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(
                    primary = Color(0xFF8AB4F8),
                    surface = Color(0xFF1E1E1E),
                    background = Color(0xFF121212)
                )
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

// Modelo de datos para las tareas
data class Task(val title: String, val description: String, val date: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val context = LocalContext.current

    // Lista de al menos 10 tareas
    val taskList: List<Task> = listOf(
        Task("Optimización de Compiladores", "Analizar optimizaciones O2 y O3 en arquitecturas x86-64.", "20-Oct-2026"),
        Task("Redes de Computadoras", "Configurar enrutamiento Router-on-a-Stick y VLANs.", "22-Oct-2026"),
        Task("Sistemas Operativos", "Implementar simulación de algoritmos de planificación CPU.", "25-Oct-2026"),
        Task("Desarrollo Web Móvil", "Diseñar interfaz responsiva con Jetpack Compose.", "27-Oct-2026"),
        Task("Arquitectura de Computadoras", "Simular esquemas de memoria caché y paginación.", "30-Oct-2026"),
        Task("Ingeniería de Software", "Documentar casos de uso y diagramas UML para SmartBarrio.", "02-Nov-2026"),
        Task("Base de Datos Avanzadas", "Optimizar consultas SQL y índices en PostgreSQL.", "05-Nov-2026"),
        Task("Seguridad Informática", "Implementar certificados SSL y políticas de firewall.", "08-Nov-2026"),
        Task("Taller de Investigación", "Redactar marco teórico del protocolo de tesis.", "12-Nov-2026"),
        Task("Inteligencia Artificial", "Entrenar modelo básico de clasificación con Python.", "15-Nov-2026")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Panel ITM - Tareas y Utilidades", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Sección de Animaciones Lottie (Columna con 2 animaciones continuas)
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Indicadores Activos (Lottie)",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LottieAnimationView(
                        url = "https://assets2.lottiefiles.com/packages/lf20_UJnqfb.json",
                        modifier = Modifier.size(120.dp),
                        label = "Sincronizando"
                    )
                    LottieAnimationView(
                        url = "https://assets9.lottiefiles.com/packages/lf20_pqn0ivic.json",
                        modifier = Modifier.size(120.dp),
                        label = "Sistema OK"
                    )
                }
            }

            // 2. Sección de Botones de Intenciones (Intents del Móvil)
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Acciones del Sistema",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ActionButton(
                        text = "Llamada de Emergencia (911)",
                        icon = Icons.Default.Phone,
                        containerColor = Color(0xFFB71C1C)
                    ) {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"))
                        context.startActivity(intent)
                    }

                    ActionButton(
                        text = "Enviar Correo a Soporte ITM",
                        icon = Icons.Default.Email,
                        containerColor = Color(0xFF0D47A1)
                    ) {
                        val intent = Intent(Intent.ACTION_SENDTO)
                        intent.data = Uri.parse("mailto:contacto@morelia.tecnm.mx")
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta Estudiantil")
                        intent.putExtra(Intent.EXTRA_TEXT, "Estimado departamento, ...")
                        context.startActivity(intent)
                    }

                    ActionButton(
                        text = "Ver Campus 1 (IT Morelia) en Mapa",
                        icon = Icons.Default.LocationOn,
                        containerColor = Color(0xFF1B5E20)
                    ) {
                        val gmmIntentUri = Uri.parse("geo:19.7027,-101.1925?z=17")
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        mapIntent.setPackage("com.google.android.apps.maps")
                        context.startActivity(mapIntent)
                    }

                    ActionButton(
                        text = "Abrir Sitio Web ITM",
                        icon = Icons.Default.Public,
                        containerColor = Color(0xFFE65100)
                    ) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.morelia.tecnm.mx"))
                        context.startActivity(intent)
                    }
                }
            }

            // 3. Sección de Tareas (LazyColumn Cards - 10 tareas)
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Tareas Pendientes (${taskList.size})",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(items = taskList) { task: Task ->
                TaskCard(task = task)
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

// Componente para las Tarjetas de Tareas
@Composable
fun TaskCard(task: Task) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = task.date,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = task.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )
        }
    }
}

// Componente para reproducir animaciones Lottie de forma continua
@Composable
fun LottieAnimationView(url: String, modifier: Modifier = Modifier, label: String) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Url(url))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.size(90.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}

// Componente para los botones de acción del sistema
@Composable
fun ActionButton(text: String, icon: ImageVector, containerColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        shape = RoundedCornerShape(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontWeight = FontWeight.Medium)
    }
}