package com.ubo.taskmanager.dto.converter;

import com.ubo.taskmanager.dto.TaskDto;
import com.ubo.taskmanager.model.Task;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TaskDtoConverter {

    public TaskDto convert(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus()
        );
    }

    public Set<TaskDto> convertList(Set<Task> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
