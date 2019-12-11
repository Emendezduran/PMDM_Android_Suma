package com.example.sumaresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_suma.*

class SumaActivity : AppCompatActivity() {

    var n1 = 0
    var n2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)

        n1 = intent.getIntExtra("num1", 0)
        n2 = intent.getIntExtra("num2", 0)

        textNum1.text = n1.toString()
        textNum2.text = n2.toString()

        btnSumar.setOnClickListener { sumar(it) }
    }

    fun sumar(it: View?) {
        val btn = it as Button
        val op = btn.text

        val resultado = n1 + n2

        val intent = Intent()
        intent.putExtra("resultadp", resultado)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
