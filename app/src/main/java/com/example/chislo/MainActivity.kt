package com.example.chislo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onGuessClick(view: View) {
        val beginField = findViewById<EditText>(R.id.begin)
        val endField = findViewById<EditText>(R.id.end)
        val left = beginField.text.toString().toIntOrNull()
        val right = endField.text.toString().toIntOrNull()

        if (left == null || right == null || left >= right) {
            Toast.makeText(this, "Введите корректный диапазон", Toast.LENGTH_SHORT).show()
            return
        }
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("left", left)
        intent.putExtra("right", right)
        startActivity(intent)
    }
}
