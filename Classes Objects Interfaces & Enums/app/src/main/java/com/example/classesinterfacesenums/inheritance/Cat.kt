package com.example.classesinterfacesenums.inheritance

import android.util.Log

class Cat(
    name: String,
    color: String,
    age: Int,
    val favoriteToy: String
) : Animal(name, color, age) {

    // we override the default behavior from Animal
    override fun speak() {
        Log.d("Cat", "Meow")
    }

    fun chaseMouse() {
        Log.d("Cat", "$name chases the mouse")
    }
}