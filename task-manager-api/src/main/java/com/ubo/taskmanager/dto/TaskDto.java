package com.ubo.taskmanager.dto;

import com.ubo.taskmanager.model.Priority;
import com.ubo.taskmanager.model.Status;

public record TaskDto(
        String id,
        String title,
        String description,
        Priority priority,
        Status status
) {
}
