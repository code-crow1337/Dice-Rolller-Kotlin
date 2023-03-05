package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //Override will come in a later lab
    override fun onCreate(savedInstanceState: Bundle?) { //no main function, but android calls instead onCreate to create the first "entry" activity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //Wonder what R refers to.
        val rollButton1: Button = findViewById(R.id.button) //button here looks like a string in the xml, but here looks like a variable?
        val rollButton2: Button = findViewById(R.id.button2)
        val textView1: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView2)
        rollButton2.setOnClickListener { rollDice(textView2) } //Lambda, no () and {} right of the bat.
        rollButton1.setOnClickListener { rollDice(textView1) }
    }

    private fun rollDice(textViewWidget: TextView) {
        val dice = Dice(6)
        val diceRoll: Int = dice.roll()

        textViewWidget.text = diceRoll.toString()


    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}