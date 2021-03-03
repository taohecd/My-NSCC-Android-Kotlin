package com.example.lab3.models

class Course(
    val students: List<Student>,
    val courseName: String,
    val courseCode: Int,
    val courseTextbook: TextBook?,
    val hasLabComponent: Boolean?
) {
}

