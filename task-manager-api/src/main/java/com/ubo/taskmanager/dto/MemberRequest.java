package com.ubo.taskmanager.dto;

import com.ubo.taskmanager.model.Team;

public record MemberRequest(
        String firstName,
        String lastName
) {
}
