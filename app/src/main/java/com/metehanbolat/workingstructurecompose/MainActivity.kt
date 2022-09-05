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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(
            "$FIRST_SCREEN/{name}/{age}/{city}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("age") { type = NavType.StringType },
                navArgument("city") { type = NavType.StringType }
            )
        ) {
            it.arguments?.let { bundle ->
                val document = Triple(
                    first = bundle.getString("name") ?: "",
                    second = bundle.getString("age") ?: "",
                    third = bundle.getString("city")?: ""
                )
                FirstScreen(navController = navController, document)
            }
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
