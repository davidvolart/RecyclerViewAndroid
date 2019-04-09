package com.example.recyclerviewproject;

import java.util.Random;

public class ToDo {

    private int id;
    private String task;

    public ToDo(String task){
        this.task=task;
        this.id= new Random().nextInt(99999);
    }

    public String getTask(){
        return task;
    }

    public void setTask(String task){
        this.task= task;
    }

    public int getId(){
        return this.id;
    }



}
