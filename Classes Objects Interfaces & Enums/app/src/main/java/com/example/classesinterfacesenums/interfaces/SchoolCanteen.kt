package com.example.classesinterfacesenums.interfaces

import android.util.Log

/**
 * A class which implements the IceCreamSeller interface
 */
class SchoolCanteen(
    val schoolName: String,
    private var isOpen: Boolean = false,
    override val iceCreamFlavors: List<String>
) : IceCreamSeller {

    fun openCanteen() {
        isOpen = !isOpen
        Log.d("SchoolCanteen", "The canteen is ${if (isOpen) "open" else "closed"}")
    }

    override fun serveIceCream(flavor: String) {
        Log.d("SchoolCanteen", "Serving up $flavor to another customer")
    }
}