package com.ubo.taskmanager.controller;

import com.ubo.taskmanager.dto.TaskDto;
import com.ubo.taskmanager.dto.TaskRequest;
import com.ubo.taskmanager.dto.TeamDto;
import com.ubo.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public ResponseEntity<TaskDto> createTask(@RequestBody @Valid TaskRequest taskRequest) {
        return ResponseEntity.ok(taskService.createTask(taskRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable String id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping()
    public ResponseEntity<Set<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PatchMapping("/{taskId}/assignTaskToTeam/{teamId}")
    public ResponseEntity<TaskDto> assignTaskToTeam(@PathVariable String taskId, @PathVariable String teamId) {
        return ResponseEntity.ok(taskService.assignTaskToTeam(taskId,teamId));
    }

}
