package com.ubo.taskmanager.dto;

import com.ubo.taskmanager.model.Team;

public record MemberDto(
        String id,
        String firstName,
        String lastName,
        Team team
) {
}
