package cmpt.safebet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NFLController {

    private static final String API_KEY = "78b1b4c59cc16d1112c63912aecc3e46";
    private static final String BASE_URL = "https://api.the-odds-api.com/v4/sports/americanfootball_nfl/odds/";

    @GetMapping("/nflodds")
    public String getNFLOdds() {
        String url = BASE_URL + "?apiKey=" + API_KEY + "&regions=us&markets=h2h,spreads&oddsFormat=american";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result; 
    }
}

