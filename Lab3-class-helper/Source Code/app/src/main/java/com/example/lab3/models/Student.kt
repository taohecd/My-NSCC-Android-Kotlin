package com.example.lab3.models

import kotlin.random.Random
import java.io.Serializable

class Student(
    val name: String,
    val address: String?,
    val yearOfStudy: Int,
    val age: Int?
): Serializable {
    companion object {
        private val studentNames = listOf(
            "Mike Jones",
            "Clive Edwards",
            "Sarah Evans",
            "Nancy Pike",
            "Davie Mathews",
            "Martin Doane",
            "Adam Jones",
            "Sarah Reynor",
            "Mara Jones"
        )

        private val addresses = listOf(
            "213 Hillcrest Ave",
            "41 Matthews Lane",
            "424 4th street center",
            "139 Mission Drive",
            "34553 Pothole Avenue",
            "234 Rogers Run"
        )

        fun getStudentsList(): List<Student> {
            val students = mutableListOf<Student>()
            for (i in 0..Random.nextInt(4, studentNames.size)) {
                val name = studentNames.random()
                val address = if (i % 2 == 0) addresses.random() else null
                val yearOfStudy = (1..4).random()
                val age = if (i % 2 != 0) Random.nextInt(20, 60) else null
                students.add(Student(
                    name = name,
                    address = address,
                    yearOfStudy = yearOfStudy,
                    age = age)
                )
            }

            return students
        }
    }
}
