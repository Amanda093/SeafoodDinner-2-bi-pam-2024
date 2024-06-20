package com.example.seafooddinner

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Tela2(navController: NavController) {
    Button(
        onClick = { navController.navigate(Routes.tela1) },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.white))
    ) {
        Text(
            text = "Veja mais",
            style = TextStyle(
                lineBreak = LineBreak.Simple,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                color = colorResource(R.color.blue)
            )
        )
    }
}