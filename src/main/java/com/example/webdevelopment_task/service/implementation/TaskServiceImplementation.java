package com.example.webdevelopment_task.service.implementation;

import com.example.webdevelopment_task.dto.TaskDto;
import com.example.webdevelopment_task.mappers.TaskMapper;
import com.example.webdevelopment_task.repository.TaskRespository;
import com.example.webdevelopment_task.service.TaskService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TaskServiceImplementation implements TaskService {
    private final TaskRespository taskRespository;
    private final TaskMapper taskMapper;
    public TaskServiceImplementation(TaskRespository taskRespository, TaskMapper taskMapper) {
        this.taskRespository = taskRespository;
        this.taskMapper = taskMapper;
    }

    @Override
    public void addTask(TaskDto taskDto) {
        var entity = taskMapper.toEntity(taskDto);
        taskRespository.save(entity);
    }

    @Override
    public void update(long id, TaskDto updatedTask) {
        var updateEntity = taskRespository.findById(id);
        if (updateEntity.isEmpty())
            throw new RuntimeException("Task with that id not found");
        var entity = updateEntity.get();
        entity.setTaskName(updatedTask.getTaskName());
        entity.setDescription(updatedTask.getDescription());
        entity.setStatus(updatedTask.getStatus());
        entity.setDateAdded(updatedTask.getDateAdded());
        entity.setEstimatedFinishDate(updatedTask.getEstimatedFinishDate());
        entity.setId(updatedTask.getId());
        taskRespository.save(entity);
    }
    @Override
    public void removeById(long id) {
        taskRespository.deleteById(id);
    }
    @Override
    public TaskDto findById(long id) {
        var entity = taskRespository.findById(id);
        if (entity.isEmpty())
            throw new RuntimeException("Task is not found");
        var dto=taskMapper.toDto(entity.get());
        return dto;
    }
    @Override
    public List<TaskDto> findAll() {
        return taskRespository.findAll().stream().map(taskMapper::toDto).toList();
    }
}