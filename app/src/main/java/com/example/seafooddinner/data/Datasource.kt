
package com.example.seafooddinner.data

import com.example.seafooddinner.R
import com.example.seafooddinner.model.Food
class Datasource() {
    fun loadFoods(): List<Food> {
        return listOf<Food>(
            Food(R.string.foodname1, R.string.foodprice1, R.drawable.foodimage1),
            Food(R.string.foodname2, R.string.foodprice2, R.drawable.foodimage2),
            Food(R.string.foodname3, R.string.foodprice3, R.drawable.foodimage3),
            Food(R.string.foodname4, R.string.foodprice4, R.drawable.foodimage4),
            Food(R.string.foodname5, R.string.foodprice5, R.drawable.foodimage5),
        )
    }
}
