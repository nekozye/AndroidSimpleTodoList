package com.neko.todolistapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskItemAdapter extends RecyclerView.Adapter<TaskItemAdapter.ViewHolder>{

    private List<String> taskitems;
    private OnLongClickListener longClickListener;

    interface OnLongClickListener {
        void onItemLongClicked(int position);
    }

    public TaskItemAdapter(List<String> tasks, OnLongClickListener longClickListener){
        this.taskitems = tasks;
        this.longClickListener = longClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textview;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textview = itemView.findViewById(android.R.id.text1);

            View.OnLongClickListener lcViewSetup = new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View view) {
                    longClickListener.onItemLongClicked(getAdapterPosition());
                    return true;
                }
            };

            itemView.setOnLongClickListener(lcViewSetup);
        }
    }


    @Override

    //need to inflate a layout from XML and returning the holde.
    public TaskItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //custom or premade layout, inflate.
        View listView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        return new ViewHolder(listView);
    }

    @Override
    public void onBindViewHolder( TaskItemAdapter.ViewHolder holder, int position) {
        //Get the data model based on position

        String currentItemContents = taskitems.get(position);

        //Set item views based on the views and data model

        holder.textview.setText(currentItemContents);

    }

    @Override
    public int getItemCount() {
        return taskitems.size();
    }


}
