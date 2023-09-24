package com.ubo.taskmanager.controller;

import com.ubo.taskmanager.dto.MemberDto;
import com.ubo.taskmanager.dto.MemberRequest;
import com.ubo.taskmanager.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

}
