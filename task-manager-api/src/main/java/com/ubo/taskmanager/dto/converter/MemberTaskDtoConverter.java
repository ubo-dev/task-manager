package com.ubo.taskmanager.dto.converter;

import com.ubo.taskmanager.dto.MemberTaskDto;
import com.ubo.taskmanager.model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberTaskDtoConverter {

    public MemberTaskDto convert(Member from) {
        return new MemberTaskDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getTeam()
        );
    }
}
