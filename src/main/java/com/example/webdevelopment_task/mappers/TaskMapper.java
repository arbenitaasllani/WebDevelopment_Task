package com.example.webdevelopment_task.mappers;

import com.example.webdevelopment_task.dto.TaskDto;
import com.example.webdevelopment_task.model.Task;
import org.springframework.stereotype.Component;
@Component
public class TaskMapper {
    public Task toEntity(TaskDto dto) {
        var entity = new Task();
        entity.setId(dto.getId());
        entity.setTaskName(dto.getTaskName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setDateAdded(dto.getDateAdded());
        entity.setEstimatedFinishDate(dto.getEstimatedFinishDate());
        return entity;
    }
    public TaskDto toDto(Task entity){
        var dto=new TaskDto();
        dto.setId(entity.getId());
        dto.setTaskName(entity.getTaskName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setDateAdded(entity.getDateAdded());
        dto.setEstimatedFinishDate(entity.getEstimatedFinishDate());
        return dto;
    }
}