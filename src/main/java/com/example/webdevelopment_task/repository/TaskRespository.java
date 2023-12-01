package com.example.webdevelopment_task.repository;

import com.example.webdevelopment_task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRespository extends JpaRepository<Task, Long> {

}
