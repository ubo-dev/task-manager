package com.ubo.taskmanager.service;

import com.ubo.taskmanager.dto.*;
import com.ubo.taskmanager.dto.converter.MemberDtoConverter;
import com.ubo.taskmanager.dto.converter.MemberTaskDtoConverter;
import com.ubo.taskmanager.exception.MemberNotFoundException;
import com.ubo.taskmanager.model.Member;
import com.ubo.taskmanager.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberDtoConverter converter;

    private final MemberTaskDtoConverter memberTaskDtoConverter;
    private final TeamService teamService;

    public MemberService(MemberRepository memberRepository, MemberDtoConverter converter, MemberTaskDtoConverter memberTaskDtoConverter, TeamService teamService) {
        this.memberRepository = memberRepository;
        this.memberTaskDtoConverter = memberTaskDtoConverter;
        this.converter = converter;
        this.teamService = teamService;
    }

    public MemberDto createMember(MemberRequest memberRequest) {
        Member member = new Member(
                memberRequest.firstName(),
                memberRequest.lastName()
        );

        return converter.convert(memberRepository.save(member));
    }

    protected Member findMemberById(String id) {
        return memberRepository.findById(id).
                orElseThrow(() -> new MemberNotFoundException("Member not found with id:" + id));
    }

    public MemberDto getMemberById(String id) {
        return converter.convert(findMemberById(id));
    }

    // assigns member to existing team
    public MemberTaskDto assignMemberToTeam(String memberId, String teamId) {
        Member member = findMemberById(memberId);

        return memberTaskDtoConverter.convert(
                memberRepository.save(
                        new Member(
                                member.getId(),
                                member.getFirstName(),
                                member.getLastName(),
                                Objects.requireNonNull(teamService.findTeamById(teamId))
                        )
                )
        );
    }

}
