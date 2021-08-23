package com.ilmirbaichurin.springboot.todolist.dao;

import com.ilmirbaichurin.springboot.todolist.entity.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> getAllTasks();

    Task getTaskById(int id);

    int addTask(Task task);

    List<Task> updateAllTasks(List<Task> newTasks);

    Task updateTaskById(int id, String newContent);

    List<Task> deleteAllTasks();

    Task deleteTaskById(int id);
}
