package com.example.simple_weather_a80

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var button01 : Button
    lateinit var editText01 : EditText
    lateinit var textView04 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_relative)

        button01 = findViewById(R.id.button1)
        editText01 = findViewById(R.id.editText)
        textView04 = findViewById(R.id.textView4)

        button01.setOnClickListener() {
            var userString = editText01.text.toString()
            var stringDisplay ="G"
            if (userString.equals("monday",ignoreCase = true)){
                stringDisplay = "Sunny + Warm"
            }
            else if (userString.equals("tuesday",ignoreCase = true)){
                stringDisplay = "Cold + Wet"
            }
            else if (userString.equals("wednesday",ignoreCase = true)){
                stringDisplay = "Foggy + Depressing"
            }
            else if (userString.equals("thursday",ignoreCase = true)){
                stringDisplay = "Scorcher"
            }
            else if (userString.equals("friday",ignoreCase = true)){
                stringDisplay = "Snow + Rain"
            }
            else if (userString.equals("saturday",ignoreCase = true)){
                stringDisplay = "Mild + Breezy"
            }
            else if (userString.equals("sunday",ignoreCase = true)){
                stringDisplay = "Miserable"
            }
            else {
                stringDisplay = "Have fun!"
            }


            textView04.text = String.format("%s", stringDisplay)
        }
    }
}