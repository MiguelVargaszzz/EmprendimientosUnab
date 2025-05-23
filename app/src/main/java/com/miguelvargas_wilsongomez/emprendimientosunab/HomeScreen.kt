package com.miguelvargas_wilsongomez.emprendimientosunab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TextFieldDefaults
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onClickLogout: () -> Unit = {}) {
    val user = Firebase.auth.currentUser
    val displayName = user?.displayName ?: "Usuario"
    val photoUrl = user?.photoUrl?.toString()

    Scaffold(
        topBar = {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF8600DD))
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Buscar...") },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                    ) {
                        Text(displayName, color = Color.White)
                        Spacer(modifier = Modifier.width(8.dp))

                        if (photoUrl != null) {
                            Image(
                                painter = rememberAsyncImagePainter(photoUrl),
                                contentDescription = "Foto de perfil",
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(RoundedCornerShape(50))
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Perfil",
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }

                Text(
                    "Categorías",
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            val promociones = listOf(
                Triple(
                    "https://img.freepik.com/psd-gratis/imprimir-poster-plantilla-macarons-confiteria_23-2148486134.jpg",
                    "POSTRE DOÑA CLARA",
                    "Delicioso pastel de chocolate con fresas frescas"
                ),
                Triple(
                    "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/dessert-promo-flyer-design-template-cf84918a010b6f48660e439e2ef5ab1a_screen.jpg",
                    "PAN DE SAN JUAN",
                    "Pan artesanal con ingredientes frescos"
                ),
                Triple(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx0yIsXcJBRcnMHXyoONg5-JzcmC3y6J6GLA&s",
                    "HELADO DE DOÑA CLEMENTINA",
                    "Helado natural de frutas, 100% artesanal"
                ),
                Triple(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTi4-MlHvfM9Ef2DJeqVIMocjKBqH3_ShOVTw&s",
                    "ENSALADA EL VERDEO",
                    "Mezcla de vegetales frescos con aderezo natural"
                )
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(promociones.size) { index ->
                    val (img, title, desc) = promociones[index]
                    PromoCard(img, title, desc)
                }
            }
        }
    }
}

@Composable
fun PromoCard(imgUrl: String, title: String, description: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE1BEE7))
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(imgUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Estrella",
                            tint = Color.Yellow,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}
