package com.example.classesinterfacesenums.inheritance

import android.util.Log

class Dog(
    name: String,
    color: String,
    age: Int,
    val temperament: String
) : Animal(name, color, age) {

    // we override the default behavior from Animal
    override fun speak() {
        Log.d("Dog", "Woof woof")
    }
}

