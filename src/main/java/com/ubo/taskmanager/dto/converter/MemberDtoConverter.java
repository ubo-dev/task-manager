package com.ubo.taskmanager.dto.converter;

import com.ubo.taskmanager.dto.MemberDto;
import com.ubo.taskmanager.model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberDtoConverter {

    public MemberDto convert(Member member) {
        return new MemberDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getTeam()
        );
    }
}
