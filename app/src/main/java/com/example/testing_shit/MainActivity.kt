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

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

// ---------------------------------------------------------
// DATA CLASSES
// ---------------------------------------------------------

data class AlignYourBodyData(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

data class FavoriteCollectionData(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

// ---------------------------------------------------------
// DATA
// ---------------------------------------------------------

private val alignYourBodyData = listOf(
    AlignYourBodyData(
        R.drawable.ab1_inversions,
        R.string.ab1_inversions
    ),
    AlignYourBodyData(
        R.drawable.ab2_quick_yoga,
        R.string.ab2_quick_yoga
    ),
    AlignYourBodyData(
        R.drawable.ab3_stretching,
        R.string.ab3_stretching
    ),
    AlignYourBodyData(
        R.drawable.ab4_tabata,
        R.string.ab4_tabata
    )
)

private val favoriteCollectionsData = listOf(
    FavoriteCollectionData(
        R.drawable.fc1_short_mantras,
        R.string.fc1_short_mantras
    ),
    FavoriteCollectionData(
        R.drawable.fc2_nature_meditations,
        R.string.fc2_nature_meditations
    )
)

// ---------------------------------------------------------
// SEARCH BAR
// ---------------------------------------------------------

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var searchText by remember {
        mutableStateOf("")
    }

    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        placeholder = {
            Text(
                text = stringResource(R.string.placeholder_search)
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

// ---------------------------------------------------------
// ALIGN YOUR BODY ELEMENT
// ---------------------------------------------------------

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
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )

        Text(
            text = stringResource(id = text),
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp,
                bottom = 8.dp
            ),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// ---------------------------------------------------------
// ALIGN YOUR BODY ROW
// ---------------------------------------------------------

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

            AlignYourBodyElement(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}

// ---------------------------------------------------------
// FAVORITE COLLECTION CARD
// ---------------------------------------------------------

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
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

// ---------------------------------------------------------
// FAVORITE COLLECTIONS GRID
// ---------------------------------------------------------

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

            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                modifier = Modifier.height(80.dp)
            )
        }
    }
}

// ---------------------------------------------------------
// HOME SECTION
// ---------------------------------------------------------

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp
                )
                .padding(horizontal = 16.dp)
        )

        content()
    }
}

// ---------------------------------------------------------
// HOME SCREEN
// ---------------------------------------------------------

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ) {

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        SearchBar(
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        HomeSection(
            title = R.string.align_your_body
        ) {
            AlignYourBodyRow()
        }

        HomeSection(
            title = R.string.favorite_collections
        ) {
            FavoriteCollectionsGrid()
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )
    }
}

// ---------------------------------------------------------
// BOTTOM NAVIGATION
// ---------------------------------------------------------

@Composable
private fun SootheBottomNavigation(
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = "Home"
                )
            },
            label = {
                Text(
                    text = stringResource(
                        R.string.bottom_navigation_home
                    )
                )
            },
            selected = true,
            onClick = {}
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile"
                )
            },
            label = {
                Text(
                    text = stringResource(
                        R.string.bottom_navigation_profile
                    )
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

// ---------------------------------------------------------
// PORTRAIT
// ---------------------------------------------------------

@Composable
fun MySootheAppPortrait() {

    MySootheTheme {

        Scaffold(
            bottomBar = {
                SootheBottomNavigation()
            }
        ) { paddingValues ->

            HomeScreen(
                modifier = Modifier.padding(
                    paddingValues
                )
            )
        }
    }
}

// ---------------------------------------------------------
// NAVIGATION RAIL
// ---------------------------------------------------------

@Composable
private fun SootheNavigationRail(
    modifier: Modifier = Modifier
) {
    NavigationRail(
        modifier = modifier.padding(
            start = 8.dp,
            end = 8.dp
        ),
        containerColor = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = "Home"
                    )
                },
                label = {
                    Text(
                        text = stringResource(
                            R.string.bottom_navigation_home
                        )
                    )
                },
                selected = true,
                onClick = {}
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Profile"
                    )
                },
                label = {
                    Text(
                        text = stringResource(
                            R.string.bottom_navigation_profile
                        )
                    )
                },
                selected = false,
                onClick = {}
            )
        }
    }
}

// ---------------------------------------------------------
// LANDSCAPE
// ---------------------------------------------------------

@Composable
fun MySootheAppLandscape() {

    MySootheTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Row(
                modifier = Modifier.fillMaxSize()
            ) {

                SootheNavigationRail()

                HomeScreen(
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

// ---------------------------------------------------------
// RESPONSIVE APP
// ---------------------------------------------------------

@Composable
fun MySootheApp(
    windowSize: WindowSizeClass
) {

    when (windowSize.widthSizeClass) {

        WindowWidthSizeClass.Compact -> {
            MySootheAppPortrait()
        }

        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            MySootheAppLandscape()
        }
    }
}

// ---------------------------------------------------------
// MAIN ACTIVITY
// ---------------------------------------------------------

class MainActivity : ComponentActivity() {

    @OptIn(
        ExperimentalMaterial3WindowSizeClassApi::class
    )
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        setContent {

            val windowSizeClass =
                calculateWindowSizeClass(this)

            MySootheApp(
                windowSize = windowSizeClass
            )
        }
    }
}

// ---------------------------------------------------------
// PREVIEWS
// ---------------------------------------------------------

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE
)
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

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE
)
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

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF5F0EE,
    heightDp = 700
)
@Composable
fun ScreenContentPreview() {

    MySootheTheme {
        MySootheAppPortrait()
    }
}