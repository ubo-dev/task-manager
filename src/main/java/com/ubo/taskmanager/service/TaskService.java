package com.ubo.taskmanager.service;

import com.ubo.taskmanager.dto.TaskDto;
import com.ubo.taskmanager.dto.TaskRequest;
import com.ubo.taskmanager.dto.TeamDto;
import com.ubo.taskmanager.dto.converter.TaskDtoConverter;
import com.ubo.taskmanager.exception.TaskNotFoundException;
import com.ubo.taskmanager.model.Task;
import com.ubo.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskDtoConverter converter;


    public TaskService(TaskRepository taskRepository,TaskDtoConverter converter) {
        this.taskRepository = taskRepository;
        this.converter = converter;
    }

    protected Task findTaskById(String id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id :" + id));
    }

    public TaskDto getTaskById(String taskId) {
        return converter.convert(findTaskById(taskId));
    }

    public TaskDto createTask(TaskRequest request) {
        Task task = new Task(
                request.title(),
                request.description()
        );
        return converter.convert(taskRepository.save(task));
    }

    public void deleteTask(String id) {
        taskRepository.delete(taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id)));
    }

    public Set<TaskDto> getAllTasks() {
        return converter.convertList(new HashSet<>(taskRepository.findAll()));
    }
}

