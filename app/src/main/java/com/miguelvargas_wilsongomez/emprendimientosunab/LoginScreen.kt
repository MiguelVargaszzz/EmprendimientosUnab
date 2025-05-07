package com.miguelvargas_wilsongomez.emprendimientosunab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(){
    Scaffold (containerColor = Color(0xFF8600DD) ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painterResource(R.drawable.logo_unab),
                contentDescription = "Logo Unab",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Iniciar Sesión",
                fontSize = 24.sp,
                color = Color(0xFFFF9900),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth(),
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
            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock,
                        contentDescription = "candado",
                        tint = Color(0xFFFF9900)
                    )
                },

                label = {
                    Text(text = "Contraseña")
                },
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors()
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9900))

            ) {
                Text("Iniciar Sesión")
            }

            Spacer(modifier = Modifier.height(24.dp))

            TextButton(onClick = {


            }) {
                Text(text = "¿No tienes una cuenta? Registrate",
                    color = Color(0xFFFF9900))
            }

        }

    }

}

@Preview
@Composable
fun LoginSreenPreview() {
    LoginScreen()
}
