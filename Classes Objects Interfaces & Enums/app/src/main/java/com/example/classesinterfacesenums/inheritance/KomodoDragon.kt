package com.example.classesinterfacesenums.inheritance

import android.util.Log

class KomodoDragon (
    name: String,
    color: String,
    age: Int,
    val scaleThickness: String
) : Animal(name, color, age) {

    fun attackHippo() {
        Log.d("Komodo", "$name attacks a hippo!")
    }
}
