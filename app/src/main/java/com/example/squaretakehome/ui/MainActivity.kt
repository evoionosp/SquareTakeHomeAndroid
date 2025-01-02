package com.example.squaretakehome.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.squaretakehome.ui.components.SquareSnackbarHost
import com.example.squaretakehome.ui.employee_list.EmployeeListScreen
import com.example.squaretakehome.ui.theme.SquareTakeHomeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           SquareApp()
        }
    }
}

@Composable
fun SquareApp() {

    val snackbarHostState = remember { SnackbarHostState() }

    SquareTakeHomeTheme {
        Scaffold(
            snackbarHost = {
                SquareSnackbarHost(hostState = snackbarHostState)
            }
        ) { innerPadding  ->
            EmployeeListScreen(
                modifier = Modifier.padding(0.dp),
                snackbarHostState = snackbarHostState
            )
        }
    }

}


