package com.example.chislo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    var left: Int = 0
    var right: Int = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        left = intent.getIntExtra("left", 0)
        right = intent.getIntExtra("right", 100)
        updateQuestion()
    }
    private fun updateQuestion() {
        val tvQuestion = findViewById<TextView>(R.id.question)

        if (right - left <= 1) {
            tvQuestion.text = "Ваше число ${left}? Если нет, то оно ${right}!"
        } else {
            val mid = (left + right) / 2
            tvQuestion.text = "Ваше число больше, чем $mid?"
        }
    }
    fun onYesNoClick(view: View) {
        val tvQuestion = findViewById<TextView>(R.id.question)
        when (view.id) {
            R.id.yes -> {
                if (right - left > 1) {
                    left = (left + right) / 2 + 1
                } else {
                    showGameResult(left)
                    return
                }
            }
            R.id.no -> {
                if (right - left > 1) {
                    right = (left + right) / 2
                } else {
                    showGameResult(right)
                    return
                }
            }
        }
        updateQuestion()
    }
    private fun showGameResult(number: Int) {
        val tvQuestion = findViewById<TextView>(R.id.question)
        val btnRestart = findViewById<Button>(R.id.restartButton)
        tvQuestion.text = "Угадано! Ваше число: $number"
        btnRestart.visibility = View.VISIBLE
    }
    fun onRestartClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
