package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("Indisches Curry", "Burger", "Maultaschen",
            "Pfannkuchen", "Spaghetti Carbonara")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn.setOnClickListener {

            val random = Random()
            val randomFood = random.nextInt(foodList.count()) //Array wird gezählt um random Nummer im Array Bereich zu erzeuget
            selectedFoodTxt.text = foodList[randomFood]

        }

    }
}