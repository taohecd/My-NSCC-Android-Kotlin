package com.example.kotlinindepth1

class Variables {

    /**
     * Variables can be declared as mutable (var) or immutable (val)
     * It is safer to always use immutable variables where possible
     */
    val immutableValue: Int = 1
    var mutableValue: Int = 1

    /**
     * A really great feature about Kotlin is type inference. The Kotlin compiler is smart and
     * can usually figure out the type of a variable when we assign it a value
     */

    val stringVariable: String = "I am a string"
    val anotherString = "I am another string"  // also of type String

    val fooInt: Int = 2
    val inferredInt = 2 // also of type Int

    /**
     * Immutable variables might be the cause of some confusion
     */

    fun immutableCollection() {
        val names = mutableListOf("Nick", "Mike", "Joe")
        names.add("Barb") // huh? I thought names was immutable?
    }

    /**
     * Variables have scope
     */

    // instance scope
    var fooInstanceVariable = true

    // local scope
    fun fooFun() {
        val fooLocalScope = 1 // variable scope restricted to this function
        fooInstanceVariable = false // variable scope restricted to this class instance
    }

    /**
     * Variables can be public or private
     */
    public val publicVariable = 1 // notice how public is redundant, it is public by default
    private val privateVariable = 1 // accessible only to an instance of this class

}