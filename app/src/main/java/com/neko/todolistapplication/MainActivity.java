package com.neko.todolistapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> listOfTasks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        listOfTasks = new ArrayList<String>();


        //button stuff
        View buttonView = findViewById(R.id.buttonAddTask);
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("tagu","button press");
            }
        };

        buttonView.setOnClickListener(ocl);


        listOfTasks.add("Test Value 1");
        listOfTasks.add("Test Value 2");


        //recylcler stuff

        RecyclerView rcyView = findViewById(R.id.recyclerfield);
        TaskItemAdapter taskAdapter = new TaskItemAdapter(listOfTasks);


        rcyView.setAdapter(taskAdapter);
        rcyView.setLayoutManager(new LinearLayoutManager(this));

    }
}