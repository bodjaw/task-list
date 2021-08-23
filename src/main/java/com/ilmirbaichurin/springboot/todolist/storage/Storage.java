package com.ilmirbaichurin.springboot.todolist.storage;

import com.ilmirbaichurin.springboot.todolist.entity.Task;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {

    private static final AtomicInteger id = new AtomicInteger(1);
    private static final Map<Integer, Task> tasksList = Collections.synchronizedMap(new HashMap<>());
    Map<Integer, Task> taesksList = new ConcurrentHashMap();

    public static List<Task> getAllTasks() {
        ArrayList<Task> allTasks = new ArrayList<>(tasksList.values());
        return allTasks;
    }

    public static Task getTaskById(int id) {
        if (tasksList.containsKey(id)) {
            return tasksList.get(id);
        }
        return null;
    }

    public static int addTask(Task task) {
        int currentId = id.get();
        task.setId(currentId);
        tasksList.put(currentId, task);
        id.incrementAndGet();
        return currentId;
    }

    public static List<Task> updateAllTasks(List<Task> newTasks) {
        tasksList.clear();
        id.set(1);
        for (Task task : newTasks) {
            addTask(task);
        }
        return newTasks;
    }

    public static Task updateTaskById(int id, String newContent) {
        if (tasksList.containsKey(id)) {
            Task taskWithChangedContent = tasksList.get(id);
            taskWithChangedContent.setContent(newContent);
            return taskWithChangedContent;
        }
        return null;
    }


    public static List<Task> deleteAllTasks() {
        List<Task> deletedTasks = new ArrayList<>(tasksList.values());
        tasksList.clear();
        return deletedTasks;
    }

    public static Task deleteTaskById(int id) {
        if (tasksList.containsKey(id)) {
            return tasksList.remove(id);
        }
        return null;
    }
}
