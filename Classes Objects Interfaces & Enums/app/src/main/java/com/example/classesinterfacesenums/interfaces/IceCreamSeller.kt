package com.example.classesinterfacesenums.interfaces

import android.util.Log

/**
 * Interfaces allow us to define contracts of state and behavior that we can "conform" / "implement"
 * to in other classes or objects
 *
 * We define an interface with the "interface" keyword
 */
interface IceCreamSeller {

    // interfaces can define state (instance variables)
    val iceCreamFlavors: List<String>

    // interfaces can have behavior (functions)
    // this function doesn't have a default implementation, so we must implement it in our conforming class
    fun serveIceCream(flavor: String)

    // this function does have a default implementation, we can either override it or use it as is in our conforming class
    fun tellCustomerIceCreamFlavors() {
        for (flavor : String in iceCreamFlavors) {
            Log.d("IceCreamSeller", flavor)
        }
    }
}