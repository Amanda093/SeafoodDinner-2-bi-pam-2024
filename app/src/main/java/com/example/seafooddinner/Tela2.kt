package com.example.seafooddinner

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.seafooddinner.ui.theme.SeafoodDinnerTheme

@Composable
fun Tela2(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(R.color.gray_100)
    ) {
        Column {
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
            SecondScreenApp()
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    SeafoodDinnerTheme(darkTheme = false, dynamicColor = false){
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(R.color.gray_100)
        ) {
            SecondScreenApp()
        }
    }
}

@Composable
fun SecondScreenApp() {
    Column {
        Row(
            modifier = Modifier
                .padding(0.dp, 32.dp, 0.dp, 0.dp)
                .height(60.dp)
                .fillMaxWidth()
                .background(colorResource(R.color.white)),
        ) {
            Icon(
                Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = "Seta",
                modifier = Modifier
                    .padding(0.dp, 16.dp, 0.dp, 16.dp)
                    .size(30.dp),
                tint = colorResource(R.color.gray_600)
            )
            Text(
                modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 16.dp),
                text = stringResource(R.string.menu),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    color = colorResource(R.color.gray_600)
                )
            )
        }
        FoodInfo()
    }
}

@Composable
fun FoodInfo() {
    Column {
        Row {
            Image(
                painter = painterResource(R.drawable.foodimage1),
                contentDescription = stringResource(R.string.foodname1),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column (
            modifier = Modifier
                .padding(16.dp,16.dp, 16.dp, 0.dp),
        ) {
            Row {
                Text(
                    text = stringResource(R.string.foodname1),
                    style = TextStyle(
                        lineBreak = LineBreak.Heading,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W500,
                        color = colorResource(R.color.navy)
                    )
                )
            }
            Row(
                modifier = Modifier
                    .padding(0.dp, 5.dp, 0.dp, 10.dp),
            ) {
                Star()
                Star()
                Star()
                Star()
                Star()
            }
            Row {
                Text(
                    text = stringResource(R.string.foodtext1),
                    style = TextStyle(
                        fontStyle = FontStyle()
                    )
                )
            }
        }
    }
}

@Composable
fun Star() {
    Icon(
        Icons.Rounded.Star,
        contentDescription = "Estrela",
        modifier = Modifier
            .size(25.dp),
        tint = colorResource(R.color.orange)
    )
}