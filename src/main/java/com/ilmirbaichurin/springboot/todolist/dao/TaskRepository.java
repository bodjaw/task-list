package com.ilmirbaichurin.springboot.todolist.dao;

import com.ilmirbaichurin.springboot.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findByContent(String content);
}


