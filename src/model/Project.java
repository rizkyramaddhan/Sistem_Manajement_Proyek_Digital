package model;

import java.util.ArrayList;

public class Project {
    private String name;
    private ArrayList <Task> tasks;

    public Project(String name){
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    // Getter name and tasks

    public String getName(){
        return name;
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void addTaks(Task task){
        tasks.add(task);
    }
 }
