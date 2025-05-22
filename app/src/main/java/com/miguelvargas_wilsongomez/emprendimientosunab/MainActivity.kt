package com.miguelvargas_wilsongomez.emprendimientosunab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.miguelvargas_wilsongomez.emprendimientosunab.ui.theme.EmprendimientosUnabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmprendimientosUnabTheme {
                NavigationApp()
            }
        }
    }
}
