package com.ilmirbaichurin.springboot.todolist.service;

import com.ilmirbaichurin.springboot.todolist.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(int id);

    Task addTask(Task task);

    List<Task> updateAllTasks(List<Task> newTasks);

    Task updateTask(Task task);
//    Task updateTaskById(int id, String newContent);

    List<Task> deleteAllTasks();

    Task deleteTaskById(int id);

    Task findByContent(String content);
}
