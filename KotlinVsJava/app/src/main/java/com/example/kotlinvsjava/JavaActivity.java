package com.example.kotlinvsjava;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JavaActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
    }

    private void conditionalExample(int num) {
        String funString;
        if (num > 2) {
            funString = "Greater than 2";
        } else {
            funString = "2 or less";
        }

        Log.d("Debug TAG", funString);
    }

    private String multipleConditions(String name) {
        String statement;

        switch (name) {
            case "Bob":
                statement = "Is a great dude";
            case "Suzy":
                statement = "Is super smart";
            case "Deb":
                statement = "Loves programming";
            default:
                statement = "No idea who this is";
        }

        return statement;
    }

    private class Dog {
        final String name;
        final String color;

        public Dog(String name, String color) {
            this.name = name;
            this.color = color;
        }
    }
}
