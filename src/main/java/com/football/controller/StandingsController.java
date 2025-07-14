package com.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.football.model.TeamStandingResponse;
import com.football.service.StandingsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/standings")
public class StandingsController {

    @Autowired
    private StandingsService standingsService;

    @GetMapping
    public TeamStandingResponse getTeamStanding(
            @RequestParam String country,
            @RequestParam String league,
            @RequestParam String team,
            @RequestParam(defaultValue = "false") boolean offline
    ) {
        return standingsService.getTeamStanding(country, league, team, offline);
    }
}
