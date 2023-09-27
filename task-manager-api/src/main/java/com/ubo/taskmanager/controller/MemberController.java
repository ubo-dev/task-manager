package com.ubo.taskmanager.controller;

import com.ubo.taskmanager.dto.MemberDto;
import com.ubo.taskmanager.dto.MemberRequest;
import com.ubo.taskmanager.dto.MemberTaskDto;
import com.ubo.taskmanager.service.MemberService;
import com.ubo.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping()
    public ResponseEntity<MemberDto> createMember(@RequestBody @Valid MemberRequest memberRequest) {
        return ResponseEntity.ok(memberService.createMember(memberRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable String id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PatchMapping("/{memberId}/assignMemberToTeam/{teamId}")
    public ResponseEntity<MemberTaskDto> assignMemberToTeam(@PathVariable String memberId, @PathVariable String teamId) {
        return ResponseEntity.ok(memberService.assignMemberToTeam(memberId,teamId));
    }

}
