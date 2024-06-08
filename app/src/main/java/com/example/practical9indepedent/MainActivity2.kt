package com.example.practical9indepedent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val guessBtn = findViewById<Button>(R.id.guessBtn)
        val EditTextNumber = findViewById<EditText>(R.id.EditTextNumber)
        guessBtn.setOnClickListener {
            val number = EditTextNumber.text.toString().toInt()
            if (number > 10) {
                Toast.makeText(this, "Введенное число больше 10", Toast.LENGTH_SHORT).show()
            } else {
                val randomNumber = Random.nextInt(10) + 1
                if (number == randomNumber) {
                    Toast.makeText(this, "Поздравляем, вы угадали число!", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(
                        this,
                        "Увы, вы не угадали. Попробуйте еще раз.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}