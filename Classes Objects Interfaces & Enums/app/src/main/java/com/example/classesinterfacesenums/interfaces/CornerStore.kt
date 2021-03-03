package com.example.classesinterfacesenums.interfaces

import android.util.Log

/**
 * A class which implements the IceCreamSeller interface
 */
class CornerStore(
    override val iceCreamFlavors: List<String>
): IceCreamSeller {

    fun sellSandwich() {
        Log.d("CornerStore", "Selling a sandwich to a customer")
    }

    override fun serveIceCream(flavor: String) {
        Log.d("CornerStore", "Happily scooping up some $flavor flavored ice cream")
    }
}