package com.example.dataclasses.models

/**
 * Data classes are used primarily as immutable containers for data
 *
 * Some examples:
 * - We fetch userAccountInfo from an API, we parse all the user accounts into immutable data class objects
 * - We want to pass an immutable data structure from one screen to the next, so we use a data class
 *
 * Data classes are also known as POJOs, plain old java objects
 *
 * We specify a data class with the "data" keyword
 */
data class Student(
    val name: String,
    val age: Int,
    val id: String,
    val major: String
) {

    // data classes do some nice things for us, they automatically generate some utility methods
    // equals() / hashCode() used for comparing objects
    // toString() which nicely formats our object for printing
    // copy() for copying the object

}