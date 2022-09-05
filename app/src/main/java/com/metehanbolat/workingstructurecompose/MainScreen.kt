package com.metehanbolat.workingstructurecompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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
            onClick = { navController.navigate(NavigationControllerConstants.FIRST_SCREEN) }
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