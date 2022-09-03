package com.metehanbolat.workingstructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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

@Composable
fun MainScreen(navController: NavController = rememberNavController()) {
    var counter by remember { mutableStateOf(0) }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Main Screen", fontSize = 50.sp)

        Button(
            onClick = { navController.navigate(FIRST_SCREEN) }
        ) {
            Text(text = "Change Screen")
        }

        Text(text = "Counter: $counter")

        Button(
            onClick = { counter++ }
        ) {
            Text(text = "Increase")
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
