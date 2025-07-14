package com.football.service;

import com.football.model.TeamStandingResponse;
import com.football.model.TeamStandingResponse.Country;
import com.football.model.TeamStandingResponse.League;
import com.football.model.TeamStandingResponse.Team;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import jakarta.annotation.PostConstruct;

@Service
public class StandingsService {

    @Value("${FOOTBALL_API_KEY}")
    private String apiKey;

    @Value("${OFFLINE_MODE:false}")
    private boolean offlineMode;

    private String apiUrl = "https://apiv3.apifootball.com/?action=get_standings&APIkey=%s";

    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
    }

    public TeamStandingResponse getTeamStanding(String countryName, String leagueName, String teamName, boolean offline) {
        if (offline) {
            return getMockResponse(countryName, leagueName, teamName);
        }

        try {
            String url = String.format(apiUrl, apiKey);
            String jsonResponse = restTemplate.getForObject(url, String.class);

            // Simulate success or parse real API response here
            return getMockResponse(countryName, leagueName, teamName); // Placeholder

        } catch (Exception e) {
            return getMockResponse(countryName, leagueName, teamName);
        }
    }

    private TeamStandingResponse getMockResponse(String countryName, String leagueName, String teamName) {
        Country country = new Country("44", countryName);
        League league = new League("149", leagueName);
        Team team = new Team("2612", teamName);
        String position = "4";

        return new TeamStandingResponse(country, league, team, position);
    }
}