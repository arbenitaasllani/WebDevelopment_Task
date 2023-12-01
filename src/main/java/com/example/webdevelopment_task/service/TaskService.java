package com.example.webdevelopment_task.service;

import com.example.webdevelopment_task.dto.TaskDto;
import java.util.List;
public interface TaskService {
    void addTask(TaskDto taskDto);
    void update(long id, TaskDto updatedTask);
    void removeById(long id);
    TaskDto findById(long id);
    List<TaskDto> findAll();
}