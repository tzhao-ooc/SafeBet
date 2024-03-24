package cmpt.safebet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NFLController {

    private static final String API_KEY = "90e3643532c2694e90b6a06071bda14a";
    private static final String ODDS_URL = "https://api.the-odds-api.com/v4/sports/americanfootball_nfl/odds/";
    private static final String SCORES_URL = "https://api.the-odds-api.com/v4/sports/americanfootball_nfl/scores/";

    @GetMapping("/nflodds")
    public String getNFLOdds() {
        String url = ODDS_URL + "?apiKey=" + API_KEY + "&regions=us&markets=h2h,spreads&oddsFormat=decimal";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result; 
    }

    @GetMapping("/nflscores")
    public String getNFLScores() {
        // added scores from 3 previous days 
        String url = SCORES_URL + "?apiKey=" + API_KEY + "&daysFrom=3";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}

