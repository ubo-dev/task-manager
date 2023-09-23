package com.ubo.taskmanager.service;

import com.ubo.taskmanager.dto.TaskDto;
import com.ubo.taskmanager.dto.TaskRequest;
import com.ubo.taskmanager.dto.converter.TaskDtoConverter;
import com.ubo.taskmanager.exception.TaskNotFoundException;
import com.ubo.taskmanager.model.Task;
import com.ubo.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskDtoConverter converter;


    public TaskService(TaskRepository taskRepository,TaskDtoConverter converter) {
        this.taskRepository = taskRepository;
        this.converter = converter;
    }

    public TaskDto getTaskById(String id) {
        return converter.convert(taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id :" + id)));
    }

    public TaskDto createTask(TaskRequest request) {
        Task task = new Task(
                request.title(),
                request.description(),
                request.priority(),
                request.status(),
                request.team()
        );
        return converter.convert(taskRepository.save(task));
    }

    public void deleteTask(String id) {
        taskRepository.delete(taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id)));
    }
}

