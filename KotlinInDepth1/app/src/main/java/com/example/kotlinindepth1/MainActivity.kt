package com.example.kotlinindepth1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var button01 : Button
    lateinit var multitext : EditText
    lateinit var nametext : EditText
    lateinit var oresult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button01 = findViewById(R.id.button)
        multitext = findViewById(R.id.editTextTextMultiLine)
        nametext = findViewById(R.id.editTextTextPersonName2)
        oresult = findViewById(R.id.textresult)


        button01.setOnClickListener {
            var userString = arrayOf<String>()
            userString = multitext.text.filters
            var userFilter = nametext.text.toString()


            var filtered = userString.filter { it.contains(userFilter) }

            oresult.text = String.format("%s", filtered)
        }

        testVariables()
        testFunctions()
        testStringTemplates()
    }

    private fun testVariables() {
        val variables = Variables()

        // mutability
        variables.mutableValue++
//        variables.immutableValue = 2

        // variable scope
        variables.fooInstanceVariable = false
//        variables.fooLocalScope = true

        // access
        val newVariable = variables.publicVariable
//        val anotherNewVariable = variables.privateVariable // notice the helpful compiler error
    }

    private fun testFunctions() {
        val functions = Functions()

        // unit return value
        val unitVariable = functions.voidReturn() // return Unit
        Log.d("TAG", unitVariable.javaClass.name) // kotlin.Unit

        // calling basic functions
        val sum = functions.sumExpression(1, 2) // 3
        Log.d("TAG", functions.greet(1)) // Hello you
        Log.d("TAG", functions.greet(2)) // Hi Everyone
        Log.d("TAG", "Sci-Fi Story = ${functions.getStoryTitleForStoryType("Sci-Fi")}")
        Log.d("TAG", "Horror Story = ${functions.getStoryTitleForStoryType("Horror")}")

        // calling functions with default arguments
        val numberOfFetches = functions.goFetch() // 1
        var previousFetches = 10
        previousFetches = functions.goFetch(previousFetches) //

        // calling functions with named arguments
        functions.greetNeighbours()
        functions.greetNeighbours(timeOfDay = "Afternoon", attitude = "Angry") // notice how we didn't include all args, why not?

        // passing a function as an argument to another function
        val sortFunction: (List<String>) -> List<String> = { unsortedPeople ->
            unsortedPeople.sorted() // a built in function that does the work of sorting for us because we're lazy today
        }
        val peopleToSort = listOf("Mike", "Sarah", "Buddy", "Jane")
        val sortedPeople = functions.sortPeople(peopleToSort, sortFunction)
        Log.d("TAG", "Sorted people = $sortedPeople")

        // functions returning other functions
        val howShouldWeSortPeople = functions.howShouldWeSortPeople("Alphabetical")
        val moreSortedPeople = functions.sortPeople(peopleToSort, howShouldWeSortPeople)
        // we won't bother logging moreSortedPeople because our howShouldWeSortPeople function doesn't actually work

        // It's OK if you are having a bit of a hard time understanding functional programming concepts
        // It will come in time with practice

        // Let's test some lambdas
        functions.doCoolStuffWithLambdas()
    }

    private fun testStringTemplates() {
        val stringTemplates = StringTemplates()
        stringTemplates.describeScooby()
    }
}