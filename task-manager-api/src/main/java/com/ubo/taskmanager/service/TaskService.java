package com.ubo.taskmanager.service;

import com.ubo.taskmanager.dto.TaskDto;
import com.ubo.taskmanager.dto.TaskRequest;
import com.ubo.taskmanager.dto.converter.TaskDtoConverter;
import com.ubo.taskmanager.exception.TaskNotFoundException;
import com.ubo.taskmanager.model.Status;
import com.ubo.taskmanager.model.Task;
import com.ubo.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskDtoConverter converter;
    private final TeamService teamService;

    public TaskService(TaskRepository taskRepository, TaskDtoConverter converter, TeamService teamService) {
        this.taskRepository = taskRepository;
        this.converter = converter;
        this.teamService = teamService;
    }

    protected Task findTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id :" + id));
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
        taskRepository.delete(taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id)));
    }

    public Set<TaskDto> getAllTasks() {
        return converter.convertList(new HashSet<>(taskRepository.findAll()));
    }

    public TaskDto assignTaskToTeam(String taskId, String teamId) {
        Task task = findTaskById(taskId);

        return converter.convert(
                taskRepository.save(
                        new Task(
                                task.getId(),
                                task.getTitle(),
                                task.getDescription(),
                                task.getPriority(),
                                task.getStatus(),
                                Objects.requireNonNull(teamService.findTeamById(teamId))
                        )
                )
        );
    }

    public TaskDto updateTaskStatus(String taskId, Status status) {
        Task task = findTaskById(taskId);
        task.setStatus(status);
        return converter.convert(
                taskRepository.save(task)
        );
    }
}



