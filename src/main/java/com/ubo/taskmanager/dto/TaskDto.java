package com.ubo.taskmanager.dto;

import com.ubo.taskmanager.model.Prioritiy;
import com.ubo.taskmanager.model.Status;

public record TaskDto(
        String id,
        String title,
        String description,
        Prioritiy prioritiy,
        Status status
) {
}
