package com.example.cleancodepractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CleanCodePracticesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Single responsibility:
     *
     * Functions should have a single responsibility
     */

    // Bad
    private fun addNumbersAndReturnLowest(a: Int, b: Int, numbers: MutableList<Int>): Int? {
        val sum = a + b
        return numbers.min()
    }

    // Good
    private fun addTwoNumber(a: Int, b: Int) = a + b

    private fun findLowestValue(numbers: List<Int>) = numbers.min()

    /**
     * A source file should be readable, almost telling a story about what the class does
     */

    private fun tellAStory() {
        val story = pickStoryFromStoryList()
        tellStory(story)
    }

    private fun pickStoryFromStoryList(): String {
        val storyType = pickRandomStoryType()
        return getStoryForType(storyType)
    }

    private fun pickRandomStoryType() = listOf("sci-fi", "drama", "horror").random()

    private fun getStoryForType(storyType: String) = when (storyType) {
        "sci-fi" -> "Enders Game"
        "drama" -> "A Handmaid's Tale"
        "horror" -> "The Crow"
        else -> ""
    }

    private fun tellStory(story: String) {
        Log.d("Story TAG", story)
    }

    /**
     * Variable names should be descriptive and camelCase
     */

    val fav = "Baseball" // bad
    val favoriteSport = "Baseball" // good
    val two_legit2Quit = false // bad
    val twoLegitToQuit = true // cringe, but good
    val x = 23.0 // bad, what is this, some sort of encoding for a char?, a Cartesian coordinate?
    val xCoordinate = 23.0 // good
    var error = 1324 // terrible
    val resourceNotFoundErrorCode = 1324 // better

    /**
     * Indentation and spacing matters
     */

        private fun terribleFun() { // indentation is off


        val numberA = 2 // unnecessary whitespace between function signature and variable declaration
        val numberB =  3

        if (numberA <=  numberB ) {


            Log.d("TAG", "Here is a log") // whitespace
        }
        else { // else statement on newline
            Log.d("TAG", "Another Log")
        }


        val a = (8 *4)+( 9 * 10 + 11) // inconsistent spacing between operators and operands

        // whitespace
    }

    private fun betterFun() {
        val numberA = 2
        val numberB = 3

        Log.d("TAG", if (numberA <= numberB) "Here is a log" else "Another log")

        val a = (8 * 4) + (9 * 10 + 11)
    }

    /**
     * Don't needlessly repeat yourself
     */

    private fun doCoolThingA(numbers: List<Int>) {
        val minNumber = numbers.min() ?: 0
        val maxNumber = numbers.max() ?: 0

        val product = maxNumber * minNumber

//        val minAndMaxNumbers = findMinAndMaxNumber(numbers)
//        val product = minAndMaxNumbers.first * minAndMaxNumbers.second

        Log.d("TAG", "The product of two numbers is $product")
    }

    private fun doCoolThingB(numbers: List<Int>) {
        val minNumber = numbers.min() ?: 0
        val maxNumber = numbers.max() ?: 0

        val sum = minNumber + maxNumber

//        val minAndMaxNumbers = findMinAndMaxNumber(numbers)
//        val sum = minAndMaxNumbers.first + minAndMaxNumbers.second

        Log.d("TAG", "The sum of all numbers is $sum")
    }

    // Instead of repeating ourselves, let's break out the common code into a function
    private fun findMinAndMaxNumber(numbers: List<Int>): Pair<Int, Int> = Pair(numbers.min() ?: 0, numbers.max() ?: 0)

    /**
     * Consistency
     *
     * - Be consistent in the way you approach your code. If you do something one way in file A,
     * then do it that way in file B (unless of course you want to improve it, then refactor file A)
     */

    /**
     * Avoid side effects in methods
     */

    var numberOfCats = 2 // counter for cats
    var numberOfDogs = 0 // counter for dogs

    private fun addNewDogToFamilyPets() {
        // val dog = Dog()
        numberOfDogs++ // it makes to increment our dog counter

        // we have an unwritten rule that if we add a dog to the family, we can't have cats
        // this is an undocumented side effect of the function and shouldn't be in here

        numberOfCats = 0

        // ideally we have a function like "addPetToFamily" that accepts a pet type. If it is a dog, then
        // it should call another method that makes the necessary adjustment to numberOfCats
    }

}