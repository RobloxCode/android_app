package com.example.tareas_desarrollo_apps_moviles

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme(primary = Color(0xFF1565C0))) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PantallaSms()
                }
            }
        }
    }
}

data class ResultadoEnvio(val numero: String, val exito: Boolean, val detalle: String)

private const val LIMITE_CARACTERES = 160 // un SMS estándar; si se pasa, se divide en partes

private fun obtenerSmsManager(context: Context): SmsManager =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        context.getSystemService(SmsManager::class.java)
    } else {
        @Suppress("DEPRECATION")
        SmsManager.getDefault()
    }

private fun parsearNumeros(texto: String): List<String> =
    texto.split(";")
        .map { it.replace(Regex("[\\s\\-()]"), "") }
        .filter { it.isNotEmpty() }
        .distinct()

private fun numeroValido(numero: String): Boolean =
    Regex("^\\+?[0-9]{7,15}$").matches(numero)

private fun enviarSms(context: Context, numero: String, mensaje: String): ResultadoEnvio {
    return try {
        val sms = obtenerSmsManager(context)
        val partes = sms.divideMessage(mensaje)
        if (partes.size > 1) {
            sms.sendMultipartTextMessage(numero, null, partes, null, null)
        } else {
            sms.sendTextMessage(numero, null, mensaje, null, null)
        }
        ResultadoEnvio(numero, true, "Enviado")
    } catch (e: Exception) {
        ResultadoEnvio(numero, false, e.message ?: "Error desconocido")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaSms() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    var numerosTexto by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }
    var enviando by remember { mutableStateOf(false) }
    var resultados by remember { mutableStateOf<List<ResultadoEnvio>>(emptyList()) }

    val numerosParseados = remember(numerosTexto) { parsearNumeros(numerosTexto) }
    val numerosValidos = numerosParseados.filter { numeroValido(it) }
    val numerosInvalidos = numerosParseados.filterNot { numeroValido(it) }

    fun iniciarEnvio() {
        scope.launch {
            enviando = true
            resultados = emptyList()
            val acumulado = mutableListOf<ResultadoEnvio>()
            for (numero in numerosValidos) {
                acumulado += enviarSms(context, numero, mensaje.trim())
                resultados = acumulado.toList()
                delay(500) // pequeña pausa entre mensajes para no saturar el módem
            }
            enviando = false
            val ok = acumulado.count { it.exito }
            snackbarHostState.showSnackbar("Proceso terminado: $ok de ${acumulado.size} enviados")
        }
    }

    val permisoLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { concedido ->
        if (concedido) {
            iniciarEnvio()
        } else {
            scope.launch {
                snackbarHostState.showSnackbar("Se necesita el permiso de SMS para enviar mensajes")
            }
        }
    }

    fun alPresionarEnviar() {
        val tienePermiso = ContextCompat.checkSelfPermission(
            context, Manifest.permission.SEND_SMS
        ) == PackageManager.PERMISSION_GRANTED
        if (tienePermiso) iniciarEnvio() else permisoLauncher.launch(Manifest.permission.SEND_SMS)
    }

    val puedeEnviar = !enviando && numerosValidos.isNotEmpty() && mensaje.isNotBlank()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("SMS Publicitario", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("1. Lista de números", style = MaterialTheme.typography.titleMedium)
                    OutlinedTextField(
                        value = numerosTexto,
                        onValueChange = { numerosTexto = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Números separados por \";\"") },
                        minLines = 3,
                        enabled = !enviando
                    )
                    Text(
                        "Válidos: ${numerosValidos.size}" +
                                if (numerosInvalidos.isNotEmpty()) "  •  Inválidos: ${numerosInvalidos.size}" else "",
                        style = MaterialTheme.typography.bodySmall,
                        color = if (numerosInvalidos.isNotEmpty()) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (numerosInvalidos.isNotEmpty()) {
                        Text(
                            "Se omitirán: ${numerosInvalidos.joinToString(", ")}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("2. Mensaje publicitario", style = MaterialTheme.typography.titleMedium)
                    OutlinedTextField(
                        value = mensaje,
                        onValueChange = { mensaje = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Escribe tu mensaje") },
                        supportingText = {
                            val partes = if (mensaje.isEmpty()) 0
                            else (mensaje.length + LIMITE_CARACTERES - 1) / LIMITE_CARACTERES
                            Text("${mensaje.length} caracteres • $partes SMS por destinatario")
                        },
                        minLines = 3,
                        enabled = !enviando
                    )
                }
            }

            Button(
                onClick = { alPresionarEnviar() },
                enabled = puedeEnviar,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                if (enviando) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(22.dp),
                        color = Color.White,
                        strokeWidth = 2.dp
                    )
                    Spacer(Modifier.width(10.dp))
                    Text("Enviando…")
                } else {
                    Text("Enviar a ${numerosValidos.size} contacto(s)")
                }
            }

            if (resultados.isNotEmpty()) {
                Text("Resultado del envío", style = MaterialTheme.typography.titleMedium)
                LazyColumn(
                    modifier = Modifier.heightIn(max = 280.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(resultados) { r ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = if (r.exito) Color(0xFFE8F5E9) else Color(0xFFFFEBEE)
                            )
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(r.numero, fontWeight = FontWeight.Medium)
                                Text(
                                    if (r.exito) "✔ ${r.detalle}" else "✘ ${r.detalle}",
                                    color = if (r.exito) Color(0xFF2E7D32) else Color(0xFFC62828)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
