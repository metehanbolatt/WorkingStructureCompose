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
import com.metehanbolat.workingstructurecompose.NavigationControllerConstants.FIRST_SCREEN

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
            onClick = {
                val name = "John"
                val age = "24"
                val city = "New York"
                navController.navigate("$FIRST_SCREEN/$name/$age/$city")
            }
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