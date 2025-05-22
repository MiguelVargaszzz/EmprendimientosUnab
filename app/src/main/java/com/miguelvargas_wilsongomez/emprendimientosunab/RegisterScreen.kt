package com.miguelvargas_wilsongomez.emprendimientosunab

import android.app.Activity
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuthActionCodeException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.auth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(onClickBack :() -> Unit = {}, onSuccesfulRegister:() -> Unit = {}){

    val auth = Firebase.auth
    val activity = LocalView.current.context as Activity

    // Estados de los input
    var inputName by remember { mutableStateOf("") }
    var inputEmail by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var inputConfirmPassword by remember { mutableStateOf("") }

    // Estados de los errores

    var nameError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var confirmPasswordError by remember { mutableStateOf("") }

    var registerError by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF8600DD)
                ),
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Box(
                            modifier = Modifier
                                .size(36.dp) // Tamaño del círculo
                                .clip(CircleShape)
                                .background(Color.White) // Fondo del círculo
                                .padding(6.dp) // Espaciado interno del ícono
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Icon Back",
                                tint = Color(0xFF8600DD) // Color del ícono, Si no es morado se ve raro, debe contrastar con el fondo
                            )
                        }
                    }
                }
            )
        },
        containerColor = Color(0xFF8600DD)
        ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(R.drawable.logo_unab),
                contentDescription = "Logo Unab",
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box( modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black.copy(alpha = 0.6f), // Agrega color negro al findo de la caja, y lo difumina con alpha
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp) // Espacio interno
            )  {
                Column {
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
                        value = inputName,
                        onValueChange = { inputName = it },
                        label = { Text("Nombre Usuario") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Usuario",
                                tint = Color(0xFFFF9900)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center), // centra la caja  del correo
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(),
                        supportingText = {
                            if (nameError.isNotEmpty()){
                                Text(
                                    text = nameError,
                                    color = Color.Red
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(24.dp)) // espacio de separacion de las cajas

                    OutlinedTextField(
                        value = inputEmail,
                        onValueChange = { inputEmail = it },
                        label = { Text("Correo Electronico") },
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

                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(),
                        supportingText = {
                            if (emailError.isNotEmpty()){
                                Text(
                                    text = emailError,
                                    color = Color.Red
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = inputPassword,
                        onValueChange = { inputPassword = it },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock,
                                contentDescription = "candado",
                                tint = Color(0xFFFF9900)
                            )
                        },
                        label = { Text("Contraseña") },
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center), // centra la caja  de la contraseña
                        visualTransformation = PasswordVisualTransformation(), // Cambiar el color de fondo de las cajas a blanco
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(),
                        supportingText = {
                            if (passwordError.isNotEmpty()){
                                Text(
                                    text = passwordError,
                                    color = Color.Red
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = inputConfirmPassword,
                        onValueChange = { inputConfirmPassword = it },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock,
                                contentDescription = "candado",
                                tint = Color(0xFFFF9900)
                            )
                        },
                        label = { Text("Confirmar Contraseña") },
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center), // centra la caja  de la contraseña
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(),
                        supportingText = {
                            if (confirmPasswordError.isNotEmpty()){
                                Text(
                                    text = confirmPasswordError,
                                    color = Color.Red
                                )
                            }
                        }
                    )

                    if (registerError.isNotEmpty()){
                        Text(registerError, color = Color.Red)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {

                            val isValidName = validateName(inputName).first
                            val isValidEmail = validateEmail(inputEmail).first
                            val isValidPassword = validatePassword(inputPassword).first
                            val isValidConfirmPassword = validateConfirmPassword(inputPassword, inputConfirmPassword).first

                            nameError = validateName(inputName).second
                            emailError = validateEmail(inputName).second
                            passwordError = validatePassword(inputName).second
                            confirmPasswordError = validateConfirmPassword(inputPassword, inputConfirmPassword).second

                            if (isValidName && isValidEmail && isValidPassword && isValidConfirmPassword){
                                auth.createUserWithEmailAndPassword(inputEmail, inputPassword).
                                        addOnCompleteListener(activity) { task ->
                                            if (task.isSuccessful){
                                                onSuccesfulRegister()
                                            }else{
                                                registerError = when(task.isSuccessful){
                                                    is FirebaseAuthInvalidCredentialsException -> "Correo invalido"
                                                    is FirebaseAuthUserCollisionException -> "Correo ya registrado"
                                                    else -> "Error al registrarse"
                                                }
                                            }
                                        }
                            }else{
                                registerError = "Hubo un error en el register"
                            }


                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .wrapContentSize(Alignment.Center),// centrar boton
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3AA6A8))
                    ) {
                        Text("Resgistrarse", textAlign = TextAlign.Center)
                    }
                    TextButton(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("¿Olvidaste tu contraseña?",
                            fontSize = 15.sp,
                            color = Color(0xFFFF9900)
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