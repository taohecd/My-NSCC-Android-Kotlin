package com.example.introapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    // Declare our variables for our UI Views
    private lateinit var nameTextView: TextView

    // Basic lifecycle method of an activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Sets the specific layout file we want to render in our activity
        setContentView(R.layout.activity_second)

        // Set the title of our activity in the top navigation bar
        title = getString(R.string.welcome)

        // Initialize our previously declared variables
        nameTextView = findViewById(R.id.name_text_view)

        configureView()
    }

    // shows the passed-in username from our MainActivity on the screen
    private fun configureView() {
        // retrieve the packaged up dictionary containing our username
        val extras = intent.extras

        // the dictionary might be null, so we have to check if it is null first
        extras?.let {
            // at this point, we know our dictionary isn't null
            // check if our dictionary contains the a key for our username
            if (extras.containsKey(USER_NAME_INTENT_KEY)) {
                // retrieve our username from the dictionary and show it on the screen
                showUserName(extras.getString(USER_NAME_INTENT_KEY)!!)
            }
        }
    }

    // shows our username on the screen
    private fun showUserName(userName: String) {
        // String.format() is a replacement tool for a string
        // we give it a placeholder string and it substitutes the username into our string at the desired position
        // check out the strings.xml for more details
        nameTextView.text = String.format(getString(R.string.hello_name), userName)
    }

    // a static object for our SecondActivity class
    // notice how the "companion object" is located at the bottom of our class, this is idiomatic style in kotlin
    companion object {
        // the key we will use to store our username in our intent dictionary
        private const val USER_NAME_INTENT_KEY: String = "userNameIntentKey"

        /**
         * A static function that creates and returns an intent
         * This function is static because it is in our companion object
         *
         * The intent is what is used to actually show our SecondActivity screen
         * It takes in two arguments, a username string and a context
         * In most cases, the context is actually the activity we are transitioning away from
         */

        fun newIntent(userName: String, context: Context): Intent {
            // we create our intent, giving it the context and specifying which class we are creating
            val intent = Intent(context, SecondActivity::class.java)

            // an intent has an internal dictionary we can use to store values
            // - use caution however, this dictionary isn't appropriate for storing large objects to pass between screens

            // we put the passed in username into our dictionary for later retrieval
            intent.putExtra(USER_NAME_INTENT_KEY, userName)
            return intent
        }
    }
}