/*
    =============================
            EJERCICIO 1
    =============================
 */

//package com.example.testing_shit

//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//class MainActivity : ComponentActivity() {
//
    //override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)
//
        //setContent {
            //MainScreen()
        //}
    //}
//}
//
//// Pantalla principal
//@Composable
//fun MainScreen() {
    //Column(
        //modifier = Modifier
            //.fillMaxSize()
            //.padding(16.dp),
        //verticalArrangement = Arrangement.spacedBy(16.dp)
    //) {
        //PersonCard(
            //name = "Juan Pérez",
            //description = "Estudiante de Ingeniería"
        //)
//
        //PersonCard(
            //name = "María López",
            //description = "Desarrolladora de software"
        //)
    //}
//}
//
//// Componente Card
//@Composable
//fun PersonCard(
    //name: String,
    //description: String
//) {
    //// Contenedor principal de la tarjeta
    //Card(
        //modifier = Modifier
            //.fillMaxWidth()
            //.height(180.dp),
        //shape = RoundedCornerShape(12.dp),
        //border = BorderStroke(1.dp, Color.Gray),
        //colors = CardDefaults.cardColors(
            //containerColor = Color.White
        //)
    //) {
        //Column(
            //modifier = Modifier.padding(8.dp)
        //) {
            //// Header con la etiqueta Card y titulo
            //Row(
                //modifier = Modifier
                    //.fillMaxWidth()
                    //.height(36.dp),
                //verticalAlignment = Alignment.CenterVertically
            //) {
                //// Etiqueta azul
                //Box(
                    //modifier = Modifier
                        //.clip(RoundedCornerShape(6.dp))
                        //.background(Color(0xFF007AFF))
                        //.padding(horizontal = 8.dp, vertical = 4.dp)
                //) {
                    //Text(
                        //text = "Card",
                        //color = Color.White,
                        //fontSize = 12.sp,
                        //fontWeight = FontWeight.Bold
                    //)
                //}
//
                //Spacer(modifier = Modifier.width(8.dp))
//
                //// Titulo de la tarjeta
                //Text(
                    //text = "Título",
                    //fontSize = 16.sp,
                    //color = Color.Gray
                //)
            //}
//
            //Spacer(modifier = Modifier.height(4.dp))
//
            //// Seccion del contenido inferior (Imagen + Datos)
            //Row(
                //modifier = Modifier
                    //.fillMaxWidth()
                    //.weight(1f)
                    //.border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
            //) {
                //// Box que simula el marco del avatar en la tarjeta
                //Box(
                    //modifier = Modifier
                        //.size(110.dp)
                        //.padding(6.dp)
                        //.border(1.dp, Color.Gray)
                        //.padding(4.dp),
                    //contentAlignment = Alignment.Center
                //) {
                    //Text(
                        //text = "👤",
                        //fontSize = 50.sp
                    //)
                //}
//
                //// Columna para informacion dividida internamente
                //Column(
                    //modifier = Modifier
                        //.fillMaxSize()
                //) {
                    //// Bloque para Nombre
                    //Box(
                        //modifier = Modifier
                            //.fillMaxWidth()
                            //.weight(1f)
                            //.border(1.dp, Color.LightGray)
                            //.padding(horizontal = 8.dp, vertical = 4.dp),
                        //contentAlignment = Alignment.CenterStart
                    //) {
                        //Column {
                            //Text(
                                //text = "Nombre",
                                //fontSize = 12.sp,
                                //color = Color.Gray
                            //)
                            //Text(
                                //text = name,
                                //fontSize = 14.sp,
                                //fontWeight = FontWeight.SemiBold
                            //)
                        //}
                    //}
//
                    //// Bloque para Descripsion
                    //Box(
                        //modifier = Modifier
                            //.fillMaxWidth()
                            //.weight(1.5f)
                            //.padding(horizontal = 8.dp, vertical = 4.dp),
                        //contentAlignment = Alignment.TopStart
                    //) {
                        //Column {
                            //Text(
                                //text = "Descripción",
                                //fontSize = 12.sp,
                                //color = Color.Gray
                            //)
                            //Text(
                                //text = description,
                                //fontSize = 13.sp
                            //)
                        //}
                    //}
                //}
            //}
        //}
    //}
//}

