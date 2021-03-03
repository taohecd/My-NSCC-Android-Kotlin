package com.example.kotlinindepth2

import android.util.Log
import java.util.*

/**
 * There are multiple commonly used tools for controlling the flow of a Kotlin program
 *
 * #1. if & if-else statements, if-else expressions
 * #2. when statements
 * #3. for & while loops
 *
 * We'll also look at how we can check types of objects at runtime
 */

class ControlFlowAndTypeChecking {

    /**
     * if & if-else statements, if-else expressions
     */
    fun ifElse() {
        // traditional style
        val weather = "sunny"
        var mood: String

        if (weather == "sunny") {
            mood = "happy"
        }

        // if else
        if (weather == "rainy") {
            mood = "sad"
        } else {
            mood = "content"
        }

        // if-else expression (this is more idiomatic Kotlin style)
        mood = if (weather == "rainy") "sad" else "content"

        // the last value in the block of an if statement will be the value of the expression
        mood = if (weather == "rainy") {
            // do some interesting stuff, maybe print some logs, calculate the user's mood
            Log.d("ControlFlow", "Testing expressions")
            "sad" // -> the resulting value of the expression, mood == "sad"
        } else {
            // do some more interesting stuff, maybe print some logs, calculate the user's mood
            Log.d("ControlFlow", "Testing expressions")
            "happy" // let's try commenting out this line and see what the compiler does
        }

    }

    /**
     * When statements are very powerful, and are similar to switch statements in Java
     */
    fun whenStatements() {
        // simple form
        when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> Log.d("ControlFlow", "Rise and shine!")
            in 12..17 -> Log.d("ControlFlow", "Good afternoon!")
            in 18..23 -> Log.d("ControlFlow", "Whew, I'm sleepy!")
            else -> Log.d("ControlFlow", "I think we're on Mars") // lets see what happens if we comment out else here
        }

        // when as an expression
        val timeOfDay = when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Morning"
            in 12..17 -> "Afternoon"
            in 18..23 -> "Evening"
            else -> "No idea!" // what happens if we comment out else here? Why is this different from before?
        }
        Log.d("ControlFlow", timeOfDay)

        // getting really fancy now, this is idiomatic style, but takes a while to get used to writing things this way
        Log.d("ControlFlow", when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Morning"
            in 12..17 -> "Afternoon"
            in 18..23 -> "Evening"
            else -> "No idea!"
        })
    }

    /**
     * Lets see how we can do type checking, which is really easy if we utilize the power of the when statement
     *
     * There are three really cool/powerful things to note here
     * #1. We can check the type of an object in Kotlin using the "is" keyword
     * #2. Using a when statement to do type checking makes it easy to check multiple types quickly
     * #3. The compiler will smart-cast our condition when it matches a type
     */
    fun typeCheck(animal: Animal) {
        when (animal) {
            is Animal.Cat -> Log.d("ControlFlow", animal.name) // smart-casting in action
            is Animal.Dog -> Log.d("ControlFlow", animal.color) // smart-casting in action
            is Animal.Parrot -> Log.d("ControlFlow", animal.greeting) // smart-casting in action

            // can anyone guess why we don't need an "else" condition here?
        }
    }

    sealed class Animal {
        data class Cat(val name: String): Animal()
        data class Dog(val color: String): Animal()
        data class Parrot(val greeting: String): Animal()
    }

    /**
     * for loops - an easy way to iterate through a collection of items, ranges
     */
    fun forLoops() {
        // lets loop through a simple range
        val range = 0..100
        for (i: Int in range) {
            Log.d("ControlFlow", i.toString())
        }

        // how about a collection of items now
        val names = listOf("Nick", "Bob", "Sarah", "Jane")
        for (name: String in names) {
            Log.d("ControlFlow", name)
        }

        // here is a little preview of how easy it is to loop through collections using functional paradigms
        // we'll cover this in more detail later in the course
        names.forEachIndexed { index, value ->
            Log.d("ControlFlow", "Index = $index, name = $value")
        }
    }

    /**
     * While loops - exact same behaviour as in other c-style languages
     */
    fun whileLoops() {

        // classic while
        var x = 0
        while (x <= 99) {
            Log.d("ControlFlow", x.toString())
            x++
        }

        // classic do while, guaranteed to run at least once
        var y = 0
        do {
            Log.d("ControlFlow", y.toString())
            y++
        } while (y <= 99)

    }
}