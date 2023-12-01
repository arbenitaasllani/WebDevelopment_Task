package com.example.webdevelopment_task.controller;
import com.example.webdevelopment_task.dto.TaskDto;
import com.example.webdevelopment_task.service.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.findAll();
    }
    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable long id){
        return taskService.findById(id);
    }
    @PostMapping
    public void addTask(@RequestBody TaskDto newTask) {
        taskService.addTask(newTask);
    }
    @PutMapping("/{id}")
    public void updateTask(@PathVariable long id, @RequestBody TaskDto updateTask) {
        taskService.update(id, updateTask);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        taskService.removeById(id);
    }
}