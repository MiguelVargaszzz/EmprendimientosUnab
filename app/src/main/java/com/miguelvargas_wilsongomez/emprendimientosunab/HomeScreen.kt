package com.miguelvargas_wilsongomez.emprendimientosunab

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(onClickLogout :() -> Unit = {}){
    Scaffold (
        topBar = {
            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF8600DD)
                ), title = {
                    Text(
                        text = "Bienvenido",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },

                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Perfil de la cuenta"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onClickLogout) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Exit app"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ){ innerPadding->
        Column (modifier = Modifier
            .padding(innerPadding)
        ) {
            Text(text = "Promociones",
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        bottom = 8.dp
                    )
            )

            val listadoDePromociones = listOf(
                "https://img.freepik.com/psd-gratis/imprimir-poster-plantilla-macarons-confiteria_23-2148486134.jpg?semt=ais_hybrid&w=740",
                "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/dessert-promo-flyer-design-template-cf84918a010b6f48660e439e2ef5ab1a_screen.jpg?ts=1604570907",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx0yIsXcJBRcnMHXyoONg5-JzcmC3y6J6GLA&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTi4-MlHvfM9Ef2DJeqVIMocjKBqH3_ShOVTw&s",
                "https://template.canva.com/EAFDJUOn0Zc/1/0/800w-0Tbvf9HBPuU.jpg"
            )
            LazyRow (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { CardPromo(listadoDePromociones[0]) }
                item { CardPromo(listadoDePromociones[1]) }
                item { CardPromo(listadoDePromociones[2]) }
                item { CardPromo(listadoDePromociones[3]) }
                item { CardPromo(listadoDePromociones[4]) }
            }



        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun CardPromo(urlImage: String){
    Card (modifier = Modifier
        .height(180.dp)
        .width(300.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(urlImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}