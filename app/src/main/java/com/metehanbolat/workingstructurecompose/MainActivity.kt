package com.metehanbolat.workingstructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.metehanbolat.workingstructurecompose.NavigationControllerConstants.FIRST_SCREEN
import com.metehanbolat.workingstructurecompose.NavigationControllerConstants.MAIN_SCREEN
import com.metehanbolat.workingstructurecompose.NavigationControllerConstants.SECOND_SCREEN
import com.metehanbolat.workingstructurecompose.ui.theme.WorkingStructureComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkingStructureComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationController()
                }
            }
        }
    }
}

@Composable
fun NavigationController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MAIN_SCREEN) {
        composable(MAIN_SCREEN) {
            MainScreen(navController = navController)
        }
        composable(FIRST_SCREEN) {
            FirstScreen(navController = navController)
        }
        composable(SECOND_SCREEN) {
            SecondScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
