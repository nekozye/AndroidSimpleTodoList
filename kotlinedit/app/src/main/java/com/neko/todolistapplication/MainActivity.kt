package com.neko.todolistapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {



    var listOfTasks = mutableListOf<String>()
    lateinit var adapter: TaskListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onLongClickListener = object :TaskListAdapter.OnLongClickListener {
            override fun onItemLongClicked(position: Int) {
                // remove the item from the list
                listOfTasks.removeAt(position)
                // update the adapter
                adapter.notifyDataSetChanged()

                saveItems()
            }
        }


        loadItems()



        val recyler_reference = findViewById<RecyclerView>(R.id.recyclerfield)
        adapter = TaskListAdapter(listOfTasks, onLongClickListener)
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

            saveItems()
        }

    }



    //save data user inputted.

    //create a method to get the file

    fun getDataFile() : File {
        return File(filesDir, "data.lstxt")
    }

    fun loadItems(){
        try{
            listOfTasks = FileUtils.readLines(getDataFile(), Charset.defaultCharset())
        }
        catch (ioException: IOException){
            ioException.printStackTrace()
        }
    }

    fun saveItems(){
        try{
            FileUtils.writeLines(getDataFile(), listOfTasks)
        }
        catch (ioException: IOException){
            ioException.printStackTrace()
        }

    }
}