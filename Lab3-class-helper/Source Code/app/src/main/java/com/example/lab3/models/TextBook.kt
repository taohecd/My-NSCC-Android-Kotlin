package com.example.lab3.models

import org.w3c.dom.Text

class TextBook(
    val name: String,
    val yearPublished: Int,
    val authors: List<String>
) {
    companion object {
        val biology = TextBook(
            name = "Principles of Biology",
            yearPublished = 1994,
            authors = listOf(
                "Dr. David Green",
                "Dr. Alice Matthews"
            )
        )
        val math = TextBook(
            name = "Fundamental Mathematics",
            yearPublished = 2010,
            authors = listOf(
                "Richard Kliner"
            )
        )
    }
}