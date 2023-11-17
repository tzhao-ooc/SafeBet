package cmpt.safebet.controllers;

import java.util.List;
import java.util.Map;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import cmpt.safebet.models.currentBet;
import cmpt.safebet.models.User;
import cmpt.safebet.models.UserRepository;
import cmpt.safebet.models.currentBetRepository;
import cmpt.safebet.models.betRecord;
import cmpt.safebet.models.betRecordRepository;

import org.springframework.web.client.RestTemplate;
import org.json.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class betRecordController {
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private currentBetRepository cbRepo;

    @Autowired
    private betRecordRepository brRepo;

    
    @GetMapping("/betRecord/profileTable")
    public String results(Model model, HttpSession session){

        // ok so what's going on here is we get a list of the current bets of the session user.
        // These bets shuold be displayed in a table on the page similar to how they are on the user stats page.
        User userN = (User) session.getAttribute("session_user");
        String username =  userN.getName(); 
        List<currentBet> currentBets = cbRepo.findByUsername(username);
        model.addAttribute("userBets", currentBets);

        return "/betRecord/profile";
    }

    @PostMapping("/betRecord/redeem")
    public String redeem(Model model, HttpSession session){
        

        // Makes a list of the current user's bets, then finds the ones that are "complete". 
        // If the bet is complete, i.e., if the game was finished and a winner of the game is determined,
        // that given bet (or bets) will award the user their winnings if they bet correctly, or no money at all
        // if they bet wrong. The redeemed bets will be deleted from the current bets table, the users balance will be
        // updated properly, and the past bet will be placed in betRecords table (this is for tracking purposes).
        //
        //
        User userN = (User) session.getAttribute("session_user");
        String username =  userN.getName(); 
        List<currentBet> currentBets = cbRepo.findByUsername(username);


        // API score data
        // First we get the string then iterate through it using json stuff library stuff.
        //
        String API_KEY = "d25e2751f1dc3ce0312aba74a09410bb";
        String SCORES_URL = "https://api.the-odds-api.com/v4/sports/americanfootball_nfl/scores/";
        String url = SCORES_URL + "?apiKey=" + API_KEY + "&daysFrom=3";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        // JSON library wizardry.
        //
        JSONArray results = new JSONArray(result);


        
        for(int i = currentBets.size(); i != 0; i--){

            
            currentBet bet = currentBets.remove(0);
            String gameID = bet.getGameID();

            

            for(int j = 0; j < results.length(); j++){

                
                if(results.getJSONObject(j).getString("id").equals(gameID) && results.getJSONObject(j).getBoolean("completed") == true){

                    JSONArray scores = results.getJSONObject(j).getJSONArray("scores");
                    String winningTeam = scores.getJSONObject(1).getString("name");

                    if(Integer.parseInt(scores.getJSONObject(0).getString("score")) > Integer.parseInt(scores.getJSONObject(1).getString("score"))){

                        
                        winningTeam = scores.getJSONObject(0).getString("name");
                        
                    }

                    

                    String betTeam = bet.getBetTeam();
                    int betID = bet.getBetId();
                    float betOdds = bet.getBetOdds();
                    int gainLoss = -(bet.getBetAmount());
                    System.out.println("winningTeam = " + winningTeam);
                    System.out.println("betTeam = " + betTeam);
                    System.out.println(betTeam.equals(winningTeam));

                    if(betTeam.equals(winningTeam)){
                        
                        gainLoss = -(gainLoss);
                        gainLoss = Math.round(gainLoss*betOdds);

                        List<User> userlist = userRepo.findByName(username);
                        User user = userlist.remove(0);
                        user.setBalance(user.getBalance() + gainLoss);
                    }

                    cbRepo.deleteById(bet.getBetId());
                    brRepo.save(new betRecord(betID, username, winningTeam, betOdds, gainLoss));

                }
            }

            



        
    }
    return "/betRecord/profile";
}
}
