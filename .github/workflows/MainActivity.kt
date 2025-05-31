package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etInput: EditText
    private var currentOperator: String? = null
    private var firstValue: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etInput = findViewById(R.id.etInput)
    }

    // Handle digit clicks (0-9)
    fun onDigitClick(view: View) {
        val buttonText = (view as Button).text.toString()
        etInput.append(buttonText)
    }

    // Handle operator clicks (+, -, *, /)
    fun onOperatorClick(view: View) {
        firstValue = etInput.text.toString().toDouble()
        currentOperator = (view as Button).text.toString()
        etInput.text.clear()
    }

    // Handle equals (=)
    fun onEqualsClick(view: View) {
        val secondValue = etInput.text.toString().toDouble()
        var result = when (currentOperator) {
            "+" -> firstValue + secondValue
            "-" -> firstValue - secondValue
            "*" -> firstValue * secondValue
            "/" -> firstValue / secondValue
            else -> return
        }
        etInput.setText(result.toString())
    }

    // Handle clear (C)
    fun onClearClick(view: View) {
        etInput.text.clear()
        currentOperator = null
    }
}
