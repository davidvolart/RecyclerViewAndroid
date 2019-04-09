package com.example.recyclerviewproject;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText todoText;
    private Button addButton;
    private RecyclerView todoList;

    private ArrayList<ToDo> data;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addButton= findViewById(R.id.button_add_todo);
        todoText=findViewById(R.id.todo_input);
        todoList=findViewById(R.id.todo_list);

        prepareDummyData();


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        todoList.setLayoutManager(mLayoutManager);

        mAdapter= new MyAdapter(data);
        todoList.setAdapter(mAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task=todoText.getText().toString();
                if(task.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Empty text");
                    builder.create().show();
                }else{
                    ToDo todo= new ToDo(task);
                    data.add(todo);
                    mAdapter.notifyDataSetChanged();
                    todoText.setText("");
                }
            }
        });


    }


    private void prepareDummyData(){

        data = new ArrayList();
        data.add(new ToDo("ToDo 1") );
        data.add(new ToDo("ToDo 2"));
        data.add(new ToDo("ToDo 3"));
        data.add(new ToDo("ToDo 4"));

    }
}
