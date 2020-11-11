package com.example.dinnerdecider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlinx.android.synthetic.main.activity_main.transfer

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("Indisches Curry", "Burger", "Maultaschen",
            "Pfannkuchen", "Spaghetti Carbonara")
    // Liste aus welcher die Gerichte random herausgezogen werden



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
       


        decideBtn.setOnClickListener {
            //Aktion die ausgeführt werden soll wenn man auf unteren Button drückt

            val random = Random()
            val randomFood = random.nextInt(foodList.count()) //Array wird gezählt um random Nummer im Array Bereich zu erzeuget
            selectedFoodTxt.text = foodList[randomFood]

        }


        transfer.setOnClickListener{
            val intent = Intent (this, YTActivity::class.java)

            startActivity(intent)
        }


    }
}