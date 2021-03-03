package com.example.kotlinindepth1

import android.util.Log
import java.lang.IllegalArgumentException

class Functions() {

    /**
     * Kotlin function signatures are as follows:
     *
     * Accessor fun {functionName} (arg1: Type): ReturnType
     */

    private fun sum(number1: Int, number2: Int): Int {
        return number1 + number2
    }

    /**
     * In Kotlin, void isn't used as a return type to represent the absence of a value
     *
     * Unit is used instead
     */

    fun voidReturn(): Unit {
        // don't return a value
    }

    // Once again, the compiler is smart however and can infer Unit as a return type, so we omit it
    private fun unitReturn() {
        // don't return a value
    }

    /**
     * Kotlin functions can also return expressions, which reduces boilerplate code
     */

    fun sumExpression(n1: Int, n2: Int) = n1 + n2 // equivalent to our previous sum function

    fun greet(numberOfPeople: Int) = if (numberOfPeople >= 2) "Hi Everyone" else "Hello You"

    fun getStoryTitleForStoryType(storyType: String) = when (storyType) {
        "Sci-Fi" -> "Blade Runner"
        "Drama" -> "Forrest Gump"
        "Horror" -> "The Thing"
        else -> {
            throw IllegalArgumentException("Unknown story type")
        }
    }

    /**
     * Functions can have default arguments
     */

    fun goFetch(fetchCounter: Int = 0): Int {
        var fetchCount = fetchCounter
        fetchCount++
        return fetchCount
    }

    /**
     * You can give names to arguments when calling functions
     */

    fun greetNeighbours(timeOfDay: String = "Morning", names: List<String> = listOf("Bob", "Jan"), attitude: String = "Happy") {
        Log.d("TAG", "Good $timeOfDay. ${names.joinToString(" ")}, today I'm $attitude")
    }

    /**
     * Functions are first-class citizens in Kotlin, meaning we can do all kinds of fun and powerful things with them
     */

    /**
     * Functions can have arguments that are other functions
     */

    fun sortPeople(people: List<String>, sortFunction: (List<String>) -> List<String>): List<String> {
        val unsortedPeople = people
        val sortedPeople = sortFunction.invoke(unsortedPeople)
        return sortedPeople

        // some interesting stuff happening here:
        // we have a function that has two arguments
        // 1. A list of String objects representing unsorted people
        // 2. A function that has a single argument (List<String>), and returns a List<String>

        // There are many ways we could sort people, alphabetically, reverse alphabetical etc
        // Instead of defining that logic here, we would pass in a function that does the sort for us
    }

    /**
     * Functions can return other functions
     *
     * Boom - head explosion
     */

    fun howShouldWeSortPeople(sortMethod: String): (List<String>) -> List<String> = when (sortMethod) {
        "Alphabetical" -> { unsortedPeople ->
            // val sortedPeople = do some work and sort people alphabetically
            val sortedPeople = listOf<String>() // we're pretending this is our list of alphabetically sorted people
            sortedPeople // our return value from our function
        }
        "Reverse Alphabetical" -> { unsortedPeople ->
            // val sortedPeople = do some work and sort people reverse alphabetically
            val sortedPeople = listOf<String>() // we're pretending this is our list of reverse sorted people
            sortedPeople // our return value from our function
        } else -> {
            throw IllegalArgumentException("Unknown sort method")
        }
    }

    /**
     * We can pass lambdas (anonymous unnamed functions) as arguments to a lot of methods
     */

    fun doCoolStuffWithLambdas() {
        val people = listOf("Nick", "Sally", "James", "Nelson", "Jeff")
        val peopleWhoStartWithN = people.filter { it.first() == 'N' } // Nick & Nelson    What do we think "it" represents?
        val peopleWhoStartWithJ = people.filter { name -> name.first() == 'J' } // notice what we did different here?
        val reverseAlphabeticalPeople = people.sortedDescending() // there are lots of built-in collection methods to make use of

        Log.d("TAG", "People who start with N: $peopleWhoStartWithN")
        Log.d("TAG", "People who start with J: $peopleWhoStartWithJ")
        Log.d("TAG", "People sorted reverse alphabetically: $reverseAlphabeticalPeople")

        // let's really see the power of lambdas
        // A. Let's take a list of names
        // B. remove anyone who's name isn't at least 6 characters
        // C. Map the remaining names to their character length
        // D. Sum all the lengths together

        val names = listOf("Alexander", "Michael", "Bob", "Sandra", "Debi", "Frank")
        val plusSixCharNamesSummed = names.filter { it.length >= 6 } // filter out names < 6 chars ["Alexander", "Michael", "Sandra"]
            .map { it.length } // create a new collection of just name lengths [9, 7, 6]
            .sumBy { it - 1 } // sum them together (9-1) + (7-1) + (6-1) = 19

        Log.d("TAG", "Fancy lambda chaining resulting value: $plusSixCharNamesSummed")

        // WOW!
        // If we wanted to get ninja level with it (but risk making it un-readable)
        val sameValueAsAbove = names.filter { it.length >= 6 }.map { it.length }.sumBy { it - 1 }

        // With great power comes great responsibility, just because you can, doesn't mean you SHOULD!
    }

}