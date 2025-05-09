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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen(){
    Scaffold (containerColor = Color(0xFF8600DD)) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
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
                        text = "Registro",
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
                                imageVector = Icons.Default.Person,
                                contentDescription = "Usuario",
                                tint = Color(0xFFFF9900)
                            )
                        }, label = {
                            Text(text = "Nombre Usuario")
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors()
                    )

                    Spacer(modifier = Modifier.height(24.dp)) // espacio de separacion de las cajas

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
                                contentDescription = "Email",
                                tint = Color(0xFFFF9900)
                            )
                        }, label = {
                            Text(text = "Correo Electronico")
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center) // centra la caja  de la contraseña
                            .width(283.dp)
                            .height(42.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock,
                                contentDescription = "candado",
                                tint = Color(0xFFFF9900)
                            )
                        },

                        label = {
                            Text(text = "Contraseña")
                        },
                        visualTransformation = PasswordVisualTransformation(), // Cambiar el color de fondo de las cajas a blanco
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center) // centra la caja  de la contraseña
                            .width(283.dp)
                            .height(42.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock,
                                contentDescription = "candado",
                                tint = Color(0xFFFF9900)
                            )
                        },

                        label = {
                            Text(text = "Confirmar Contraseña")
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .wrapContentSize(Alignment.Center) // centrar boton
                            .width(113.dp)
                            .height(37.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3AA6A8))

                    ) {
                        Text("Iniciar Sesión", textAlign = TextAlign.Center)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    TextButton(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "¿No tienes una cuenta? Registrate",
                            color = Color(0xFFFF9900), modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally) // Centrar el texto
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}