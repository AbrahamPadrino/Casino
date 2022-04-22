package com.example.casino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(dice,dice1Image)
            rollDice(dice2,dice2Image)
            }
        // lanza los dados cuando inicia la aplicación
        rollDice(dice, dice1Image)
        rollDice(dice2, dice2Image)

    }

    /** Lanza los dados y actualiza la pantalla con los resultados
     *
     */
    val dice = Dice(6)
    val dice2 = Dice(6)

    val dice1Image: ImageView =
        findViewById(R.id.imageView2) //Llama a findViewById() para buscar el elemento ImageView.
    val dice2Image: ImageView =
        findViewById(R.id.imageView4)

    private fun rollDice(dice: Dice, diceImage: ImageView) {
        // Create new Dice object with 6 sides and roll the dice
        val diceRoll =
            dice.roll() //Llama al método roll() a fin de lanzar el dado y guarda el resultado en una variable
        //Determine qué ID de recurso extraíble usar en función de al lanzamiento de dados.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Actualiza ImageView con el ID de recurso correcto
        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}