package com.ilmirbaichurin.springboot.todolist.service;

import com.ilmirbaichurin.springboot.todolist.dao.TaskRepository;
import com.ilmirbaichurin.springboot.todolist.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> updateAllTasks(List<Task> newTasks) {
        taskRepository.deleteAll();
        taskRepository.saveAll(newTasks);
        return newTasks;
    }

    @Override
    public Task updateTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public List<Task> deleteAllTasks() {
        List<Task> deletedTasks = taskRepository.findAll();
        taskRepository.deleteAll();
        return deletedTasks;
    }

    @Override
    public Task deleteTaskById(int id) {
        Task remoteTask = getTaskById(id);
        taskRepository.deleteById(id);
        return remoteTask;
    }

}
