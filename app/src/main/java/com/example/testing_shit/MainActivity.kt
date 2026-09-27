package com.example.testing_shit

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
//import androidx.compose.foundation.layout.fillMaxHeight
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
//import androidx.constraintlayout.compose.ConstraintLayout
//
//class MainActivity : ComponentActivity() {
    //override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)
        //setContent {
            //Ejercicio1Screen()
            ////Ejercicio2Screen()
            ////Ejercicio3Screen()
            ////Ejercicio4Screen()
        //}
    //}
//}
//
///* ============================================================================
   //EJERCICIO 1: Interfaz basada en Cards (MD3) con Orientación Vertical
   //============================================================================ */
//
//@Composable
//fun Ejercicio1Screen() {
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
        //PersonCard(
            //name = "María López",
            //description = "Desarrolladora de software"
        //)
    //}
//}
//
//@Composable
//fun PersonCard(
    //name: String,
    //description: String
//) {
    //Card(
        //modifier = Modifier
            //.fillMaxWidth()
            //.height(180.dp),
        //shape = RoundedCornerShape(12.dp),
        //border = BorderStroke(1.dp, Color.Gray),
        //colors = CardDefaults.cardColors(containerColor = Color.White)
    //) {
        //Column(modifier = Modifier.padding(8.dp)) {
            //// Encabezado (Insignia "Card" + Título)
            //Row(
                //modifier = Modifier
                    //.fillMaxWidth()
                    //.height(36.dp),
                //verticalAlignment = Alignment.CenterVertically
            //) {
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
                //Text(
                    //text = "Título",
                    //fontSize = 16.sp,
                    //color = Color.Gray
                //)
            //}
//
            //Spacer(modifier = Modifier.height(4.dp))
//
            //// Área de contenido dividida en bloques con bordes
            //Row(
                //modifier = Modifier
                    //.fillMaxWidth()
                    //.weight(1f)
                    //.border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
            //) {
                //// Marco del avatar de usuario
                //Box(
                    //modifier = Modifier
                        //.size(110.dp)
                        //.padding(6.dp)
                        //.border(1.dp, Color.Gray)
                        //.padding(4.dp),
                    //contentAlignment = Alignment.Center
                //) {
                    //Text(text = "👤", fontSize = 50.sp)
                //}
//
                //// Columna para campos de información con líneas divisoras
                //Column(modifier = Modifier.fillMaxSize()) {
                    //Box(
                        //modifier = Modifier
                            //.fillMaxWidth()
                            //.weight(1f)
                            //.border(1.dp, Color.LightGray)
                            //.padding(horizontal = 8.dp, vertical = 4.dp),
                        //contentAlignment = Alignment.CenterStart
                    //) {
                        //Column {
                            //Text(text = "Nombre", fontSize = 12.sp, color = Color.Gray)
                            //Text(text = name, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                        //}
                    //}
//
                    //Box(
                        //modifier = Modifier
                            //.fillMaxWidth()
                            //.weight(1.5f)
                            //.padding(horizontal = 8.dp, vertical = 4.dp),
                        //contentAlignment = Alignment.TopStart
                    //) {
                        //Column {
                            //Text(text = "Descripción", fontSize = 12.sp, color = Color.Gray)
                            //Text(text = description, fontSize = 13.sp)
                        //}
                    //}
                //}
            //}
        //}
    //}
//}
//
///* ============================================================================
   //EJERCICIO 2: Interfaz usando Box con Fondos de Color para Alineación
   //============================================================================ */
//
//@Composable
//fun Ejercicio2Screen() {
    //Box(
        //modifier = Modifier
            //.fillMaxSize()
            //.background(Color.White)
    //) {
        //// Esquina superior izquierda
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color.Red)
                //.align(Alignment.TopStart)
        //)
//
        //// Esquina superior derecha
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color(0xFF00008B))
                //.align(Alignment.TopEnd)
        //)
//
        //// Centro absoluto
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color.Yellow)
                //.align(Alignment.Center)
        //)
//
        //// Esquina inferior izquierda
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color(0xFF800080))
                //.align(Alignment.BottomStart)
        //)
//
        //// Esquina inferior derecha
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color(0xFF00FF00))
                //.align(Alignment.BottomEnd)
        //)
    //}
//}
//
///* ============================================================================
   //EJERCICIO 3: Interfaz con Box Proporcionales (Uso de Weights)
   //============================================================================ */
//
//@Composable
//fun Ejercicio3Screen() {
    //Row(modifier = Modifier.fillMaxSize()) {
        //// Primera columna: Verde (15%), Rojo (15%), Azul (70%)
        //ColumnLayoutOne(
            //modifier = Modifier
                //.weight(1f)
                //.fillMaxHeight()
        //)
//
        //Spacer(modifier = Modifier.width(8.dp))
//
        //// Segunda columna: Verde (15%), Rojo (75%), Azul (10%)
        //ColumnLayoutTwo(
            //modifier = Modifier
                //.weight(1f)
                //.fillMaxHeight()
        //)
    //}
//}
//
//@Composable
//fun ColumnLayoutOne(modifier: Modifier = Modifier) {
    //Column(modifier = modifier) {
        //Box(
            //modifier = Modifier
                //.fillMaxWidth()
                //.weight(0.15f)
                //.background(Color(0xFF66FF00))
        //)
        //Box(
            //modifier = Modifier
                //.fillMaxWidth()
                //.weight(0.15f)
                //.background(Color.Red)
        //)
        //Box(
            //modifier = Modifier
                //.fillMaxWidth()
                //.weight(0.7f)
                //.background(Color(0xFF00008B))
        //)
    //}
//}
//
//@Composable
//fun ColumnLayoutTwo(modifier: Modifier = Modifier) {
    //Column(modifier = modifier) {
        //Box(
            //modifier = Modifier
                //.fillMaxWidth()
                //.weight(0.15f)
                //.background(Color(0xFF66FF00))
        //)
        //Box(
            //modifier = Modifier
                //.fillMaxWidth()
                //.weight(0.75f)
                //.background(Color.Red)
        //)
        //Box(
            //modifier = Modifier
                //.fillMaxWidth()
                //.weight(0.1f)
                //.background(Color(0xFF00008B))
        //)
    //}
//}
//
///* ============================================================================
   //EJERCICIO 4: Disposición de Componentes con ConstraintLayout
   //============================================================================ */
//
//@Composable
//fun Ejercicio4Screen() {
    //ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        //val (yellowBox, blueBox, greenBox, purpleBox, redBox) = createRefs()
//
        //// Elemento central
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color(0xFF66FF00))
                //.constrainAs(greenBox) {
                    //top.linkTo(parent.top)
                    //bottom.linkTo(parent.bottom)
                    //start.linkTo(parent.start)
                    //end.linkTo(parent.end)
                //}
        //)
//
        //// Bloque superior izquierdo
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color.Yellow)
                //.constrainAs(yellowBox) {
                    //bottom.linkTo(greenBox.top)
                    //end.linkTo(greenBox.start)
                //}
        //)
//
        //// Bloque superior derecho
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color(0xFF00008B))
                //.constrainAs(blueBox) {
                    //bottom.linkTo(greenBox.top)
                    //start.linkTo(greenBox.end)
                //}
        //)

        // Bloque inferior izquierdo
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color(0xFF800080))
                //.constrainAs(purpleBox) {
                    //top.linkTo(greenBox.bottom)
                    //end.linkTo(greenBox.start)
                //}
        //)
//
        //// Bloque inferior derecho
        //Box(
            //modifier = Modifier
                //.size(70.dp)
                //.background(Color.Red)
                //.constrainAs(redBox) {
                    //top.linkTo(greenBox.bottom)
                    //start.linkTo(greenBox.end)
                //}
        //)
    //}
//}

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search


@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    MySootheTheme {
        AlignYourBodyElement(
            text = R.string.ab1_inversions,
            drawable = R.drawable.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


//..


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
    MySootheTheme {
        FavoriteCollectionCard(
            text = R.string.fc2_nature_meditations,
            drawable = R.drawable.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}

import androidx.compose.foundation.layout.PaddingValues

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(item.drawable, item.text, Modifier.height(80.dp))
        }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
@Composable
fun ScreenContentPreview() {
    MySootheTheme { HomeScreen() }
}

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}


import androidx.compose.material3.Scaffold

@Composable
fun MySootheAppPortrait() {
    MySootheTheme {
        Scaffold(
            bottomBar = { SootheBottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}


import androidx.compose.foundation.layout.fillMaxHeight

@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_home))
                },
                selected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_profile))
                },
                selected = false,
                onClick = {}
            )
        }
    }
}
@Composable
fun MySootheAppLandscape() {
    MySootheTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                SootheNavigationRail()
                HomeScreen()
            }
        }
    }
}

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
@Composable
fun MySootheApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MySootheAppPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            MySootheAppLandscape()
        }
    }
}

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            MySootheApp(windowSizeClass)
        }
    }
}

