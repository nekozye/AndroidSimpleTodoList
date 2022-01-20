package com.neko.todolistapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // add button listener check
        findViewById<Button>(R.id.buttonAddTask).setOnClickListener {

            //executed when button is pressed
            Log.i("todolist_button","User Clicked on button")
        }
    }
}