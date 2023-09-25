package com.ubo.taskmanager.dto;

import com.ubo.taskmanager.model.Member;
import com.ubo.taskmanager.model.Task;

import java.util.Set;

public record TeamDto(
        String id,
        String name,
        Set<Member> members,
        Set<Task> tasks
) {
}
