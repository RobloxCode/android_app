package com.example.tareas_desarrollo_apps_moviles

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// 1. Definición de rutas centralizadas
object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

// 2. Configuración del NavHost
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }

        composable(
            route = "${Routes.HOME}/{user}/{paterno}/{materno}/{password}",
            arguments = listOf(
                navArgument("user") { type = NavType.StringType },
                navArgument("paterno") { type = NavType.StringType },
                navArgument("materno") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val user = backStackEntry.arguments?.getString("user") ?: ""
            val paterno = backStackEntry.arguments?.getString("paterno") ?: ""
            val materno = backStackEntry.arguments?.getString("materno") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            HomeScreen(
                user = user,
                paterno = paterno,
                materno = materno,
                password = password
            )
        }
    }
}

// 3. Pantalla de Login (origen)
@Composable
fun LoginScreen(navController: NavController) {
    var user by remember { mutableStateOf("") }
    var paterno by remember { mutableStateOf("") }
    var materno by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("Usuario") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = paterno,
            onValueChange = { paterno = it },
            label = { Text("Apellido paterno") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = materno,
            onValueChange = { materno = it },
            label = { Text("Apellido materno") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                // Uri.encode evita que caracteres como "/" rompan la ruta
                navController.navigate(
                    "${Routes.HOME}/${Uri.encode(user)}/${Uri.encode(paterno)}" +
                            "/${Uri.encode(materno)}/${Uri.encode(password)}"
                )
            },
            enabled = user.isNotBlank() && paterno.isNotBlank() &&
                    materno.isNotBlank() && password.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }
    }
}

// 4. Pantalla de Home (destino)
@Composable
fun HomeScreen(user: String, paterno: String, materno: String, password: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Text("Usuario: $user $paterno")
        Text("Contraseña: $password")
    }
}
