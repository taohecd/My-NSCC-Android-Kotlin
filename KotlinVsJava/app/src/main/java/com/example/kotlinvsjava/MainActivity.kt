package com.example.kotlinvsjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun conditionalExample(num: Int) {
        // Conditional statements can be expressions
        val funString = if (num > 2) "Greater than 2" else "2 or less"
        Log.d("Debug TAG", funString)
    }

    // The above could also be written in this way, compare this to the java method
    // Things to notice: Omits return keyword, single expression evaluated, type inference in action
    private fun functionExpression(num: Int) = if (num > 2) "Greater than 2" else "2 or less"

    // When statements vs switches
    // When statements are also expressions and can return values
    private fun multipleConditions(name: String) = when (name) {
            "Bob" -> "Is a great dude"
            "Suzy" -> "Is super smart"
            "Deb" -> "Loves programming"
            else -> "No idea who this is"
    }

    // This was much uglier in Java before Java 8 which introduced some functional style capabilities
    private fun functionalExample(passedInFun: (Int) -> String) {
        val stringProducedByFunction = passedInFun(1)
    }

    // class declaration, default constructors, instance variable declaration inference
    private class Dog(val name: String, val color: String)
}