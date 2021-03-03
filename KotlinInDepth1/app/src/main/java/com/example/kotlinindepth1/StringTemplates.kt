package com.example.kotlinindepth1

import android.util.Log

/**
 * String templates allow us to utilize variables, expressions, and call functions within Strings
 */
class StringTemplates {

    private val name = "Scooby Doo"
    private val age = 24
    private val isScared = true
    private val heightInMeters = 3.12F

    fun describeScooby() {
        Log.d("TAG", "Our character's name is $name") // variable
        Log.d("TAG", "$name is $age years old") // multiple variables
        Log.d("TAG", "Is $name scared = $isScared") // multiple variables
        Log.d("TAG", "$name's height if he grew 1 meter would be ${heightInMeters + 1.0F}") // expression
        Log.d("TAG", "Our character's first name is: ${name.split(' ').first()}") // function
    }
}