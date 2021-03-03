package com.example.dataclasses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dataclasses.models.Student
import com.example.dataclasses.models.TraditionalStudentClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testDataClasses()
    }

    private fun testDataClasses() {
        // let's say I read in a bunch of student data from a database and all of this data is supposed
        // to be read-only. I would create instance of data classes to hold that immutable data

        // let's pretend I'm getting these argument values from a database record
        val bobby = Student("Bobby", 21, "fe4233df", "Psychology")
        val suzie = Student("Suzie", 32, "fe3421Dg", "Math")
        val kayla = Student("Kayla", 42, "fe9583Ke", "Math")

        // we never plan on modifying these values, we only want to display them to our user in the UI

        // now we can do some useful things with the methods that are generated for us
        Log.d("MainActivity", bobby.toString())
        Log.d("MainActivity", suzie.toString())
        val kaylaV2 = kayla.copy()
        val bobbyEqualsSuzie = bobby == suzie
        val bobbyHash = bobby.hashCode()

        val traditionalStudent = TraditionalStudentClass("fooName", 32, "fadfffd", "Science")
        val traditionalHash = traditionalStudent.hashCode()
    }
}