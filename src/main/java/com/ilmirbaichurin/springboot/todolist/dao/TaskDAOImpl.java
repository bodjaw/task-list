package com.ilmirbaichurin.springboot.todolist.dao;

import com.ilmirbaichurin.springboot.todolist.entity.Task;
import com.ilmirbaichurin.springboot.todolist.storage.Storage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    @Override
    public List<Task> getAllTasks() {
        return Storage.getAllTasks();
    }

    @Override
    public Task getTaskById(int id) {
        return Storage.getTaskById(id);
    }

    @Override
    public int addTask(Task task) {
        return Storage.addTask(task);
    }

    @Override
    public List<Task> updateAllTasks(List<Task> newTasks) {
        return Storage.updateAllTasks(newTasks);
    }

    @Override
    public Task updateTaskById(int id, String newContent) {
        return Storage.updateTaskById(id, newContent);
    }

    @Override
    public List<Task> deleteAllTasks() {
        return Storage.deleteAllTasks();
    }

    @Override
    public Task deleteTaskById(int id) {
        return Storage.deleteTaskById(id);
    }
}
