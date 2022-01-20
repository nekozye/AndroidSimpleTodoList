package com.neko.todolistapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    val listOfTasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // add button listener check
        findViewById<Button>(R.id.buttonAddTask).setOnClickListener {

            //executed when button is pressed

        }

        listOfTasks.add("Do Laundry")
        listOfTasks.add("Go for a walk")



        val recyler_reference = findViewById<RecyclerView>(R.id.recyclerfield)
        val adapter = TaskListAdapter(listOfTasks)
        recyler_reference.adapter = adapter
        recyler_reference.layoutManager = LinearLayoutManager(this)


    }
}