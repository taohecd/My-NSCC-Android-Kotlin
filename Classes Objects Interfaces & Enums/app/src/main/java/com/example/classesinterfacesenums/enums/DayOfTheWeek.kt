package com.example.classesinterfacesenums.enums

import android.util.Log

/**
 * Enums are great for defining a type which has a pre-determined list of values
 * Each entry in an Enum class is UPPERCASE in Kotlin
 *
 * Enums can have variables, and each entry must be initialized with a value for that variable
 *
 * private val greeting: String is the variable, notice how in each day entry we include a value for greeting
 */
enum class DayOfTheWeek(private val greeting: String) {
    MONDAY("Happy Monday!"),
    TUESDAY("Terrible Tuesday"),
    WEDNESDAY("Halfway there!"),
    THURSDAY("Almost there...."),
    FRIDAY("TGIF"),
    SATURDAY("PARTY TIME"),
    SUNDAY("Ugh, back to work tomorrow");

    // Enums can also have functions
    fun greet() {
        Log.d("DayOfTheWeek", greeting)
    }
}