package com.example.introapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    /**
     * If we want to reference UI elements in our code, we must declare them as variables in our class file
     * We typically declare UI elements as "private lateinit var"
     *
     * private - for encapsulation
     * lateinit - a promise to the compiler that we will initialize our variable later
     * var - must be a var, if it was a val we'd be forced to initialize it when we declare it
     */

    private lateinit var goButton: Button
    private lateinit var nameEditText: EditText

    /**
     * The "onCreate" function is the main "lifecycle" function of an activity class
     * It is the first thing that "happens" in our class, so it is a good spot to initialize our variables
     * and set up our screen
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // sets the specific layout file we want to render in our activity
         setContentView(R.layout.activity_main_linear)
//        setContentView(R.layout.activity_main_relative)
//        setContentView(R.layout.activity_main_constraint)

        // findViewById is an activity method that looks through our inflated layout for a specific
        // UI element based on the id we gave it in our associated layout file
        goButton = findViewById(R.id.go_button) // initialize our goButton instance variable
        nameEditText = findViewById(R.id.name_edit_text) // initialize our nameEditText variable

        // once our UI elements are initialized, we should configure them
        // it is good coding form to create dedicated functions to do this
        configureGoButton()
        configureNameEditText()
    }

    private fun configureGoButton() {
        // buttons typically need to perform an action when we click them
        // we can add an onClickListener for this
        goButton.setOnClickListener {
            // this is the code that runs when our user taps our button

            // we retrieve the text our user typed into our username edit text
            val userName = nameEditText.text

            // we create a new intent which we will use to start our new activity with
            // we pass our username into the newIntent() function to store it for later retrieval
            val intent = SecondActivity.newIntent(userName.toString(), this@MainActivity)

            // start our new activity using our intent
            startActivity(intent)
        }
    }

    /**
     * This is a utility function that hides the user's virtual keyboard after they hit the "enter" button,
     * not overly important
     */
    private fun configureNameEditText() {
        nameEditText.setOnEditorActionListener { v, actionId, _ ->
                if (actionId == KeyEvent.KEYCODE_ENDCALL) {
                    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(v.windowToken, 0)
                    false
                } else {
                    true
                }
        }
    }
}