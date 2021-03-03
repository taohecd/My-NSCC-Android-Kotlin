package com.example.lab3.models

import kotlin.random.Random

class CourseList(
    val biology: Course,
    val math: Course,
    val science: Course
) {
    companion object {
        fun getCourses(): CourseList {
            val biology = Course(
                students = Student.getStudentsList(),
                courseName = "Biology",
                courseCode = 1001,
                courseTextbook = TextBook.biology,
                hasLabComponent = null
            )
            val math = Course(
                students = Student.getStudentsList(),
                courseName = "Math",
                courseCode = 342,
                courseTextbook = TextBook.math,
                hasLabComponent = true
            )
            val science = Course(
                students = Student.getStudentsList(),
                courseName = "Science",
                courseCode = 5342,
                courseTextbook = null,
                hasLabComponent = false
            )
            return CourseList(biology, math, science)
        }
    }
}