package com.miguelvargas_wilsongomez.emprendimientosunab

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.auth

@Composable
fun LoginScreen(onClickRegister :()-> Unit = {}, onSuccessfulLogin : () -> Unit = {}) {
    Scaffold (containerColor = Color(0xFF8600DD) ) { paddingValues ->

        val auth = Firebase.auth
        val activity = LocalView.current.context as Activity

        // Estados de los inputs

        var inputEmail by remember { mutableStateOf("") }
        var inputPassword by remember { mutableStateOf("") }

        // Estados de los Errores

        var loginError by remember { mutableStateOf("")}
        var emailError by remember { mutableStateOf("")}
        var passwordError by remember { mutableStateOf("")}


        Column (
            modifier = Modifier.padding(paddingValues)
                .fillMaxWidth()
                .imePadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painterResource(R.drawable.logo_unab),
                contentDescription = "Logo Unab"

            )

            Spacer(modifier = Modifier.height(24.dp))

            Box( modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black.copy(alpha = 0.6f), // Agrega color negro al findo de la caja, y lo difumina con alpha
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp) // Espacio interno
            ) {
                Column (modifier = Modifier // Column que contiene las cajas de texto
                    .padding(20.dp),
                ){
                    Text(
                        text = "Iniciar Sesión",
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
                        onValueChange = { inputEmail = it },
                        label = { Text("Correo Electronico")},
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email",
                                tint = Color(0xFFFF9900)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center), // centra la caja  del correo
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(),
                        supportingText = {
                            if (emailError.isNotEmpty()){
                                Text(
                                    text = emailError,
                                    color = Color.Red
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.None,
                            autoCorrect = false,
                            keyboardType = KeyboardType.Email
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = inputPassword,
                        onValueChange = {inputPassword = it},
                        label = { Text("Contraseña") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock,
                                contentDescription = "candado",
                                tint = Color(0xFFFF9900)
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center), // centra la caja  de la contraseña
                        visualTransformation = PasswordVisualTransformation(), // ocultar la contraseña con ***
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(),
                        supportingText = {
                            if (passwordError.isNotEmpty()){
                                Text(
                                    text = passwordError,
                                    color = Color.Red
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.None,
                            autoCorrect = false,
                            keyboardType = KeyboardType.Password
                        )
                    )

                    if (loginError.isNotEmpty()){
                        Text(
                            loginError,
                            color = Color.Red,
                            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {

                            val isValiedEmail: Boolean = validateEmail(inputEmail).first
                            val isValiedPassword: Boolean = validatePassword(inputPassword).first

                            emailError = validateEmail((inputEmail)).second
                            passwordError = validatePassword(inputPassword).second

                            if (isValiedEmail && isValiedPassword){
                                auth.signInWithEmailAndPassword(inputEmail,inputPassword)
                                    .addOnCompleteListener(activity) { task ->
                                        if (task.isSuccessful){
                                            onSuccessfulLogin()
                                        }else{
                                            loginError = when(task.exception){
                                                is FirebaseAuthInvalidCredentialsException -> "Correo o contraseña incorrecta"
                                                is FirebaseAuthInvalidUserException -> "No existe una cuenta con este correo"
                                                else -> "Error al iniciar sesión. Intenta de nuevo"
                                            }
                                        }
                                    }
                            } else {

                            }

                        },
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize(Alignment.Center), // boton
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3AA6A8))

                        ) {
                            Text("Iniciar Sesión", textAlign = TextAlign.Center)
                    }

                    TextButton(
                        onClick = onClickRegister,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("¿No tienes una cuenta? Registrate",
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
fun LoginScreenPreview() {
    LoginScreen()
}
