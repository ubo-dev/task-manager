package com.ubo.taskmanager.dto.converter;

import com.ubo.taskmanager.dto.TaskDto;
import com.ubo.taskmanager.model.Task;
import org.springframework.stereotype.Component;

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
}
