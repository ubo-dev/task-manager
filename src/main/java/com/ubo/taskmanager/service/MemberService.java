package com.ubo.taskmanager.service;

import com.ubo.taskmanager.dto.MemberDto;
import com.ubo.taskmanager.dto.MemberRequest;
import com.ubo.taskmanager.dto.converter.MemberDtoConverter;
import com.ubo.taskmanager.model.Member;
import com.ubo.taskmanager.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberDtoConverter converter;

    public MemberService(MemberRepository memberRepository,MemberDtoConverter converter) {
        this.memberRepository = memberRepository;
        this.converter = converter;
    }

    public MemberDto createMember(MemberRequest memberRequest) {
        Member member = new Member(
                memberRequest.firstName(),
                memberRequest.lastName(),
                memberRequest.team()
        );

        return converter.convert(memberRepository.save(member));
    }
}
