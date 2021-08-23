package com.ilmirbaichurin.springboot.todolist.controller;

import com.ilmirbaichurin.springboot.todolist.entity.Task;
import com.ilmirbaichurin.springboot.todolist.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TasksController {

    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String showAllTasks(Model model) {
        List<Task> allTasks = taskService.getAllTasks();
        model.addAttribute("tasks", allTasks);
        return "all-tasks";
    }

    @GetMapping("/tasks/create")
    public String createFormForNewTask(Task task) {
        return "add-task";
    }

    @PostMapping("/tasks")
    public String addTask(@ModelAttribute Task task, Model model) {
        model.addAttribute("task", task);
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTaskById(@PathVariable("id") int id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/update/{id}")
    public String createFormForUpdateTask(@PathVariable("id") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }

    @PostMapping("/tasks/update")
    public String updateTaskById(Task task) {
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/clear")
    public String deleteAllTasks() {
        taskService.deleteAllTasks();
        return "redirect:/tasks";
    }
}
