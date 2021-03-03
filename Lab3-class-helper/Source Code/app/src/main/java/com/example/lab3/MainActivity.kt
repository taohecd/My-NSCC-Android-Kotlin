package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.lab3.models.CourseList

class MainActivity : AppCompatActivity() {

    private val courseList = CourseList.getCourses()
    
    // TODO: Update and read from the currentlySelectedCourse variable when necessary
    private var currentlySelectedCourse: Course? = null

    private lateinit var courseBiologyTextView: TextView
    private lateinit var courseMathTextView: TextView
    private lateinit var courseScienceTextView: TextView
    private lateinit var viewStudentsButton: Button

    // TODO: Add necessary instance variables

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // findViewById
        viewStudentsButton = findViewById(R.id.view_students_button)
        courseBiologyTextView = findViewById(R.id.course_biology_textView)
        courseMathTextView = findViewById(R.id.course_math_textView)
        courseScienceTextView = findViewById(R.id.course_science_textView)

        // TODO: Continue hooking up UI elements

        configureViewStudentsButton()
        configureCourseTextViews()
    }

    // TODO: Configure view students button to show the ViewStudentsActivity when clicked
    private fun configureViewStudentsButton() {
        
    }

    private fun configureCourseTextViews() {
        // I've set up the click handler on the course text views already
        courseBiologyTextView.setOnClickListener(courseOnClickListener)
        courseMathTextView.setOnClickListener(courseOnClickListener)
        courseScienceTextView.setOnClickListener(courseOnClickListener)

        // TODO: set the course name on the appropriate text view
    }

    // triggers when a course text view is tapped
    private val courseOnClickListener: (View) -> Unit = { selectedCourse ->

        // TODO: Course info should be reset when a new course is selected to prevent bugs
        // TODO: If a course doesn't have a textbook, hide the entire textbook section
        when (selectedCourse.id) {
            R.id.course_biology_textView -> {
                // TODO: display course info
                // instead of repeating this logic three times you might consider setting up a
                // function that accepts the various arguments you need to display in your UI
            }
            R.id.course_math_textView -> {
                // TODO: display course info
            }
            R.id.course_science_textView -> {
                // TODO: display course info
            }
        }
    }
}
