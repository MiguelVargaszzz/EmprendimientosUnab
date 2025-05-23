package com.miguelvargas_wilsongomez.emprendimientosunab

import android.util.Log
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun ForgotPasswordScreen (onClickBack: () -> Unit = {}) {

    val auth = Firebase.auth

    // Estados input

    var inputEmail by remember { mutableStateOf("") }


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
                        value = inputEmail,
                        onValueChange = {inputEmail = it},
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
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button (
                        onClick = {
                            Firebase.auth.sendPasswordResetEmail(inputEmail)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        Log.d("ForgotPassword", "Email enviado.")
                                    } else {
                                        Log.e("ForgotPassword", "Error al enviar email.")
                                    }
                                }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9900))
                    ) {
                        Text("Recuperar contraseña", color = Color.White)
                    }

                    Button(
                        onClick = onClickBack,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                    ) {
                        Text("Volver al login", color = Color.White)
                    }
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