package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.jvm.internal.Ref

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener()
        {
      

            val weight = editTextWeight.text.toString().toDouble()
            val height = editTextHeight.text.toString().toDouble()

            val bmi = calculate(height, weight)

            try {



            if (bmi < 18.5) {
                imageViewProfile.setImageResource((R.drawable.under))
                textViewBMI.setText(String.format("%.2f",bmi)+"(Under)")

            } else if (bmi >= 18.5 || bmi <= 24.9) {
                imageViewProfile.setImageResource((R.drawable.normal))
                textViewBMI.setText(String.format("%.2f",bmi)+"(Normal)")
            } else if (bmi >= 25) {
                imageViewProfile.setImageResource((R.drawable.over))
                textViewBMI.setText(String.format("%.2f",bmi)+"(Over)")
            }
        }catch (ex:Exception)
        {
            val toast:Toast =Toast.makeText(applicationContext,"Please input value", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }

    }

        buttonReset.setOnClickListener()
        {

            editTextHeight.setText(" ")
            editTextWeight.setText(" ")
            textViewBMI.setText(" ")
            imageViewProfile.setImageResource(R.drawable.empty)
            editTextWeight.requestFocus()
        }
    }

    private fun calculate(height: Double, weight: Double): Double {
        val bmiResult: Double = weight / (height * height)
        return bmiResult

        // textViewBMI.text = " BMI is %.2f".format(BMI)

    }
}

