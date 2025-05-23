package com.miguelvargas_wilsongomez.emprendimientosunab

import androidx.compose.runtime.Composable
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun NavigationApp (){
    val myNavController = rememberNavController()
    var myStartDestination: String = "login"

    val auth = Firebase.auth

    // Mantener la sesion iniciada
    val currentUser = auth.currentUser

    if(currentUser != null){
        myStartDestination = "home"
    } else {
        myStartDestination = "login"
    }


    NavHost(
        navController = myNavController,
        startDestination = myStartDestination
    ){
        composable("login") {
            LoginScreen(onClickRegister ={
                myNavController.navigate("register")
            }, onSuccessfulLogin = {
                myNavController.navigate("home"){
                    popUpTo("login"){inclusive = true}
                }
            },
                onForgotPassword = {
                    myNavController.navigate("forgotPassword")
                }
                )
        }
        composable("register") {
            RegisterScreen(onClickBack = {
                myNavController.popBackStack()
            }, onSuccesfulRegister = {
                myNavController.navigate("home"){
                    popUpTo("register") { inclusive = true }
                }

            }
            )
        }
        composable("forgotPassword") {
            ForgotPasswordScreen(
                onClickBack = {
                    myNavController.popBackStack()
                }
            )
        }
        composable("home") {
            HomeScreen(
                onClickLogout = {
                    Firebase.auth.signOut()
                    myNavController.navigate("login"){
                        popUpTo("home") {inclusive = true }
                    }
                }
            )
        }
        composable ("perfil") {
            val user = Firebase.auth.currentUser
            val name = user?.displayName ?: "Nombre no disponible"
            val email = user?.email ?: "Correo no disponible"
            val photoUrl = user?.photoUrl?.toString()

            ProfileScreen(
                userName = name,
                userEmail = email,
                userPhotoUrl = photoUrl,
                onLogout = {
                    Firebase.auth.signOut()
                    myNavController.navigate("login") {
                        popUpTo("perfil") { inclusive = true }
                    }
                }
            )
        }
    }

}