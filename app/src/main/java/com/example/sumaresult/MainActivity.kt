package com.example.sumaresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEnviar.setOnClickListener { enviar(it) }
    }

    fun enviar(view: View) {
        val btn = view as Button
        val intent = Intent(this, SumaActivity::class.java)
        var num1 = numero1.text
        var num2 = numero2.text

        try {

            var n1 = Integer.parseInt(num1.toString())
            var n2 = Integer.parseInt(num2.toString())

            val intent = Intent(this, SumaActivity::class.java)
            intent.putExtra("n1", n1)
            intent.putExtra("n2", n2)

            startActivityForResult(intent, 1)

        } catch (nfe: NumberFormatException) {
            Toast.makeText(this, "Numero Invalido", Toast.LENGTH_SHORT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            val result = data?.getIntExtra("result", 0)
            resultado.text = result.toString()
        }


    }


}