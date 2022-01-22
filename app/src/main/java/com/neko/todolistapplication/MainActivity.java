package com.neko.todolistapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> listOfTasks;
    private TaskItemAdapter taskAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);



        listOfTasks = new ArrayList<String>();

        //long click on inside recycler

        TaskItemAdapter.OnLongClickListener olcl = new TaskItemAdapter.OnLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                // remove item
                listOfTasks.remove(position);
                // notify adapter
                taskAdapter.notifyDataSetChanged();

                saveItems();
            }

        };

        loadItems();


        //recylcler stuff

        RecyclerView rcyView = findViewById(R.id.recyclerfield);
        taskAdapter = new TaskItemAdapter(listOfTasks,olcl);


        rcyView.setAdapter(taskAdapter);
        rcyView.setLayoutManager(new LinearLayoutManager(this));



        //button stuff

        EditText userinputfieldview = findViewById(R.id.newTaskField);

        View buttonView = findViewById(R.id.buttonAddTask);
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Grab the text the user has inputed into @id/newTaskField


                String userInputtedTask = userinputfieldview.getText().toString();

                // 2. add the string to the list of tasks arraylist

                listOfTasks.add(userInputtedTask);

                // 3. notify the adapter about the data change

                taskAdapter.notifyItemInserted(listOfTasks.size()-1);

                // 4. reset task field

                userinputfieldview.setText("");

                // 5. persistant save update

                saveItems();

            }
        };


        buttonView.setOnClickListener(ocl);




    }

    //file io system

    private File getDataFile(){
        // simple file list, nothing particular
        return new File(getFilesDir(), "data_java_ver.dat");
    }

    private void loadItems(){
        Log.i("filemanager:","file read attempt from "+getDataFile().getAbsolutePath().toString());
        try{
            this.listOfTasks = (ArrayList<String>) FileUtils.readLines(getDataFile(), Charset.defaultCharset());
            Log.i("filemanager:","file read from "+getDataFile().getAbsolutePath().toString());
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }

    }

    private void saveItems(){
        try{
            FileUtils.writeLines(getDataFile(), this.listOfTasks);
            Log.i("filemanager:","file saved in "+getDataFile().getAbsolutePath().toString());
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }


}