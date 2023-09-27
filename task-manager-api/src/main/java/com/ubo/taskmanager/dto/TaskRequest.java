package com.ubo.taskmanager.dto;

import com.ubo.taskmanager.model.Priority;
import com.ubo.taskmanager.model.Status;

public record TaskRequest(
        String title,
        String description

) {
}
