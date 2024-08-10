package com.aurum.struts.repository;

import com.aurum.struts.model.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {
    private Map<Integer, Task> taskList ;//= new HashMap<>();

    public TaskRepository(){
        taskList = new HashMap<>();
    }

    public Map<Integer, Task> addTask(Task task){
        taskList.put(taskList.size()+1,task);
        System.out.println(task.getTodo());
        System.out.println("addtask");
        return null;
    }

    public Map<Integer, Task> listTask(){
        return taskList;
    }

    public Task getTask(int id){
        System.out.println(id);
        return taskList.getOrDefault(id, null);
    }

    public Task updateTask(int id,Task task){
        Task updTask = taskList.getOrDefault(id,null);
        if (task.getTodo()!=null ){
            taskList.put(id, task);
        }
        return task;
    }
    public Map<Integer, Task> removeTask(int id){

        if (taskList.containsKey(id)){
            taskList.remove(id);
        }
        for (int i = id + 1; i <= taskList.size() + 1 ; i++) {
            Task removeTask = taskList.get(i);
            taskList.remove(i);
            taskList.put(i - 1, removeTask);
        }
        return taskList;
    }
}
