package com.example.classesinterfacesenums.classes

import android.util.Log

/**
 * Classes in Kotlin can have primary and secondary constructors
 *
 * Primary constructors are part of the class declaration syntax as shown below
 * Ex. class Foo(instanceVarA: String, instanceVarB: Int) {}
 *
 * Secondary constructors are declare more traditionally within the body of the class
 */
class Car(
    val make: String,
    var kms: Int
) {

    private var color: String? = null
    private var characteristic: String? = null

    // we can also create initializer blocks which run when we create an instance of our class
    init {
        characteristic = "Unremarkable"
        carsCreated++ // we'll come back to this in a minute
    }

    // A secondary constructor within the body of the class
    // We can choose to instead instantiate an object of this class using our secondary constructor
    // instead of using our primary constructor

    // notice how we have to delegate to our primary constructor with : this(make, kms)
    constructor(make: String, kms: Int, color: String) : this(make, kms) {
        this.color = color
    }

    // classes can have state (instance variables) and behavior (methods)

    // state
    var isInspected = false
    var hasWarranty = true

    // behavior
    fun turnOnCar() {
        Log.d("Car", "Vroom vroom")
    }

    // companion objects are static state and behavior accessible without needing to instantiate
    // an object of that class
    companion object {
        private var carsCreated: Int = 0

        fun getCarCreated(): Int {
            return carsCreated
        }
    }
}