package com.example.kotlinindepth2

import android.util.Log

/**
 * Nullable types are widely used in Kotlin. This is one of the major key differences between Java and Kotlin
 * Nullable types are fantastic because they widely eliminate the dreaded "NullPointException" commonly seen
 * in Java and eliminates a bunch of boilerplate code like this:
 *
 * if (fooBar != null) {
 *     // do something with fooBar
 * }
 *
 * If for any reason in your program you think that a type could be null, mark it with the "?" character
 * eg. var nullableString: String? = null
 */
class NullableTypes {

    /**
     * Lets try making some types as nullable
     */

    // instance variables
    private var myName: String? = null
    private var anotherName: String? = "Nicko" // can we guess why we might want to mark a variable we've initialized as nullable?
    private var fooInt: Int? = null
    private var anotherInt: Int? = 10

    // function signatures
    fun nullableArgs(isCold: Boolean?) {
        // if isCold isn't null, we can use it some way, if it is null, we can choose to do something else
    }

    fun nullableReturn(): String? {
        val programmingIsFun = true
        return if (programmingIsFun) "someRandomString, doesn't matter what" else null
    }

    // let's look at how we can work with nullable types easily
    fun workingWithNulls(name: String?): String? {

        // this .let{} is essentially the equivalent to Java's more boilerplate if (fooBar != null) { // do thing with it }
        name?.let {
            Log.d("NullableTypes", it) // wait, what the heck is this "it"???
        }

        name?.let { n -> // we have the power to name this variable whatever we want
            Log.d("NullableTypes", n)
        }

        // if we really feel like writing Java style code to work with a null value, we can
        if (name != null) {
            Log.d("NullableTypes", "Name length = ${name.length}") // the compiler is smart, it knows that we've already checked to see if name is null or not
        }

        // what if we don't want to go through the hassle of writing "let" or writing a classic java style null check?
        Log.d("NullableTypes", "Name length = ${name?.length}") // woah! cool, but be careful, if name is null, what will our log print?

        // so, what can we do about the above problem?
        Log.d("NullableTypes", "Name length = ${name?.length ?: "unknown"}") // the null-coalescing operator (?:) to the rescue

        // the null-coalescing operator gives us the ability to substitute a null value with a default value
        val nameLength = name?.length ?: 0
        val myName = name ?: "Nick"

        Log.d("NullableTypes", "Name length = $nameLength, name = $myName")

        // if we're feeling really risky, we can do what is called "unwrapping" on a null value with the "bang" aka !! operator
        val totallyNotNullName = name!!
        totallyNotNullName.hashCode() // you better hope that name wasn't null, or you've just trigger a NullPointerException in Kotlin, which is totally embarrassing

        // in all seriousness, don't use the !! operator, practice safe null checking with the Kotlin features available to you

        return null // we marked our return type as String?, so we can return null, or return a String value
    }

    /**
     * Let's look at some more advanced ways we can work with nullable types
     */
    fun advancedNull() {
        val address: Address? = Address(null)
        val company: Company? = Company("ACME", null)
        val nicko: Person? = Person(address, company)

        // so in the above variables, we've got a whole bunch of null types, let's start logging their details
//        val nicksCompanyAddress = nicko.company.address // this doesn't compile because all of these values are nullable, there is no guarantee they hold non-null values
        val nicksCompanyAddress = nicko?.company?.address ?: "unknown" // we can chain ? operators across multiple nullable objects

        // if we
    }

    class Address(val street: String?)
    class Company(val name: String?, val address: Address?)
    class Person(val address: Address?, val company: Company?)
}