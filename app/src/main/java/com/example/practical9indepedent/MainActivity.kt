package com.example.practical9indepedent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var guessedNumber: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val guessBtn = findViewById<Button>(R.id.guessBtn)
        val EditTextNumber = findViewById<EditText>(R.id.EditTextNumber)
        guessBtn.setOnClickListener {
            if (guessedNumber == null) {
                guessedNumber = EditTextNumber.text.toString().toInt()
                EditTextNumber.text.clear()
                EditTextNumber.hint = "Угадайте число"
                Toast.makeText(
                    this,
                    "Число загадано, теперь попробуйте его угадать.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val guess = EditTextNumber.text.toString().toInt()
                if (guess == guessedNumber) {
                    Toast.makeText(this, "Поздравляем, вы угадали число!", Toast.LENGTH_SHORT)
                        .show()
                    val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("guess", guess)
                    startActivity(intent)
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
