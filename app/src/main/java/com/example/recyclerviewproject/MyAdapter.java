package com.example.recyclerviewproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<ToDo> data;

    public MyAdapter(ArrayList<ToDo> data){
        this.data=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.todo_item,viewGroup,false);
        ViewHolder vh= new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

            ToDo todo= data.get(i);
            holder.mId.setText(todo.getId()+"");
            holder.mTask.setText(todo.getTask());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mId;
        public TextView mTask;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            mId = itemView.findViewById(R.id.todo_id);
            mTask = itemView.findViewById(R.id.todo_task);
        }



    }


}
