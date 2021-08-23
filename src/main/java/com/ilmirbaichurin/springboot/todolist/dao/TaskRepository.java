package com.ilmirbaichurin.springboot.todolist.dao;

import com.ilmirbaichurin.springboot.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findByContent(String content);
}


