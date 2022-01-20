package com.neko.todolistapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    val listOfTasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        listOfTasks.add("Do Laundry")
        listOfTasks.add("Go for a walk")



        val recyler_reference = findViewById<RecyclerView>(R.id.recyclerfield)
        val adapter = TaskListAdapter(listOfTasks)
        recyler_reference.adapter = adapter
        recyler_reference.layoutManager = LinearLayoutManager(this)

        var inputTextField = findViewById<EditText>(R.id.newTaskField)

        // add button listener check
        findViewById<Button>(R.id.buttonAddTask).setOnClickListener {

            //grab the text from the @+id/newTaskField

            val userInputTask = inputTextField.text.toString()

            //add the string to our list of tasks: listOfTasks

            listOfTasks.add(userInputTask)

            //adapter calling for data update
            adapter.notifyItemInserted(listOfTasks.size - 1)

            //text field reset


            inputTextField.setText("")


        }

    }
}