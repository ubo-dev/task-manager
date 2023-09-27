package com.ubo.taskmanager.dto.converter;

import com.ubo.taskmanager.dto.TeamDto;
import com.ubo.taskmanager.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamDtoConverter {

    public TeamDto convert(Team from) {
        return new TeamDto(
                from.getId(),
                from.getName(),
                from.getMember(),
                from.getTask()
        );
    }
}
