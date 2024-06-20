package com.example.seafooddinner

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.seafooddinner.data.Datasource
import com.example.seafooddinner.model.Food
import com.example.seafooddinner.ui.theme.SeafoodDinnerTheme

@Composable
fun Tela1(navController: NavController) {
    SeafoodDinnerTheme(darkTheme = false, dynamicColor = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(R.color.gray_100)
        ) {
            Column {
                Button(
                    onClick = { navController.navigate(Routes.tela2) },
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
                DinnerApp()
            }

        }
    }
}


@Preview
@Composable
fun DinnerAppPreview() {
    SeafoodDinnerTheme(darkTheme = false, dynamicColor = false){
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(R.color.gray_100)
        ) {
            DinnerApp()
        }
    }
}

@Composable
fun DinnerApp() {
    Column {
        Row(
            modifier = Modifier
                .padding(0.dp, 32.dp, 0.dp, 0.dp)
                .height(50.dp)
                .fillMaxWidth()
                .background(colorResource(R.color.white)),
        ){
            Text(
                text = stringResource(R.string.menu),
                modifier = Modifier.padding(16.dp,14.dp, 16.dp, 0.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    color = colorResource(R.color.gray_600)
                )
            )
        }
        FoodList(
            foodList = Datasource().loadFoods(),
        )
    }

}

@Composable
fun FoodList(foodList: List<Food>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(foodList) { food ->
            FoodCard(
                food = food,
                modifier = Modifier.padding(10.dp,32.dp, 16.dp, 0.dp)
            )
        }
    }
}

@Composable
fun FoodCard(food: Food, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .background(colorResource(R.color.white))
            .shadow(
                elevation = 10.dp,
                ambientColor = colorResource(R.color.navy),
                spotColor = colorResource(R.color.navy),
                shape = RoundedCornerShape(20.dp),
            )
            .fillMaxWidth()
            .height(225.dp),

        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(R.color.white)),
        elevation = CardDefaults.cardElevation(20.dp),
        content = {
            Column {
                Image(
                    painter = painterResource(food.imageResourceId),
                    contentDescription = stringResource(food.nameId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = LocalContext.current.getString(food.nameId),
                    modifier = Modifier.padding(16.dp,16.dp, 16.dp, 0.dp),
                    style = TextStyle(
                        lineBreak = LineBreak.Simple,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500,
                        color = colorResource(R.color.navy)
                    )
                )
                Text(
                    text = LocalContext.current.getString(food.priceId),
                    modifier = Modifier.padding(16.dp,4.dp, 16.dp, 0.dp),
                    style = TextStyle(
                        lineBreak = LineBreak.Simple,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        color = colorResource(R.color.gray_600)
                    )
                )

            }
        }
    )
}
