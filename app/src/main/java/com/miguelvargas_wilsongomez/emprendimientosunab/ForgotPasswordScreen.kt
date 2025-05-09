package com.miguelvargas_wilsongomez.emprendimientosunab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ForgotPasswordScreen () {
    Scaffold (containerColor = Color(0xFF8600DD)) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
                .fillMaxWidth()
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(R.drawable.logo_unab),
                contentDescription = "Logo Unab",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(320.dp)
            )

            Box( modifier = Modifier
                .fillMaxWidth()
                .width(390.dp)
                .height(474.dp)
                .background(color = Color.Black.copy(alpha = 0.6f), // Agrega color negro al findo de la caja, y lo difumina con alpha
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp) // Espacio interno
            )  {
                Column (modifier = Modifier
                    .padding(20.dp)
                ){
                    Text(
                        text = "¿Olvidaste tu contraseña?",
                        fontSize = 24.sp,
                        color = Color(0xFFFF9900),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center) // centrar el "iniciar Sesión"
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center) // centra la caja  del correo
                            .width(283.dp)
                            .height(42.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Correo",
                                tint = Color(0xFFFF9900)
                            )
                        }, label = {
                            Text(text = "Correo Unab")
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Ingresa tu correo  y te enviaremos un mensaje para la recuperacion de su contraseña ",
                        fontSize = 16.sp,
                        color = Color(0xFFFFFFFF),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center) // centra la caja  del correo
                    )

                }

            }
        }
    }
}

@Preview
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen()
}