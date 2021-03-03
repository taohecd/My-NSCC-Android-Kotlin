package com.example.classesinterfacesenums.inheritance

import android.util.Log

/**
 * Kotlin classes are final by default, to support inheritance we
 * must mark the class as "open"
 */
open class Animal(
    val name: String,
    val color: String,
    val age: Int
) {
    // by marking this as "open", we can override this behavior in a subclass
    open fun speak() {
        Log.d("Animal", "Generic animal noises")
    }

    fun walk() {
        Log.d("Animal", "Animal begins to walk")
    }
}