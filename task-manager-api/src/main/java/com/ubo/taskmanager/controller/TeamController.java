package com.ubo.taskmanager.controller;

import com.ubo.taskmanager.dto.MemberTaskDto;
import com.ubo.taskmanager.dto.TeamDto;
import com.ubo.taskmanager.dto.TeamRequest;
import com.ubo.taskmanager.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable @Valid String id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @PostMapping()
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamRequest request) {
        return ResponseEntity.ok(teamService.createTeam(request));
    }

}
