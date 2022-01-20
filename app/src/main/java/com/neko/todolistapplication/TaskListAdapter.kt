package com.neko.todolistapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * A connection between the actual data and the display of the said list. "Driver of a data->display"
 */

class TaskListAdapter (private val listOfItems: List<String>) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>(){



    //usually involves inflation of the layout from XML and returning the holder afterwards
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // inflation of the layout
        val itemView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)


        //return the inflated view
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //get data model based on position

        val item = listOfItems[position]

        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView

        init{
            textView = itemView.findViewById(android.R.id.text1)
        }
    }

}