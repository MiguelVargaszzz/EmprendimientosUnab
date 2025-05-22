package com.miguelvargas_wilsongomez.emprendimientosunab

import android.util.Patterns


fun validateEmail(email: String): Pair <Boolean, String>{
    return when {
        email.isEmpty() -> Pair(false, "El correo es requerido.")
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> Pair (false, "El correo no es valido")
        !email.endsWith("@unab.edu.com") -> Pair (false, "Ese email no es de dominio UNAB")
        else -> Pair (true, "")
    }
}

fun validatePassword(password: String): Pair <Boolean, String>{
    return when {
        password.isEmpty() -> Pair(false, "La contraseña es requerida.")
        password.length < 8 -> Pair (false, "La contraseña debe tener al menos 8 caracteristicas")
        !password.any() { it.isDigit() } -> Pair(false, "La contraseña debe tener al menos un número")
        !password.any() { it.isLowerCase() } -> Pair(false, "La contraseña debe tener al menos una letra minuscula")
        !password.any() { it.isUpperCase() } -> Pair(false, "La contraseña debe tener al menos una letra mayuscula")
        else -> Pair (true, "")
    }
}

fun validateName(name: String): Pair <Boolean, String>{
    return when {
        name.isEmpty() -> Pair(false, "El nombre es requerido")
        name.length < 3 -> Pair(false, "El nombre debe tener al menos 3 caracteres")
        else -> Pair(true, "")
    }
}

fun validateConfirmPassword(password: String, confirmPassword: String): Pair <Boolean, String>{
    return when {
        confirmPassword.isEmpty() -> Pair(false, "La contraseña es requerida.")
        confirmPassword != password -> Pair (false, "La contraseña no coinciden")
        else -> Pair (true, "")
    }
}