package com.ubo.taskmanager.service;

import com.ubo.taskmanager.dto.TeamDto;
import com.ubo.taskmanager.dto.TeamRequest;
import com.ubo.taskmanager.dto.converter.TeamDtoConverter;
import com.ubo.taskmanager.exception.TeamNotFoundException;
import com.ubo.taskmanager.model.Task;
import com.ubo.taskmanager.model.Team;
import com.ubo.taskmanager.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamDtoConverter converter;

    public TeamService(TeamRepository teamRepository, TeamDtoConverter converter) {
        this.teamRepository = teamRepository;
        this.converter = converter;
    }

    public TeamDto createTeam(TeamRequest teamRequest) {
        Team team = new Team(
                teamRequest.name()
        );
        return converter.convert(teamRepository.save(team));
    }

    protected Team findTeamById(String id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team not found with id:" + id));
    }

    public TeamDto getTeamById(String teamId) {
        return converter.convert(findTeamById(teamId));
    }

}
