package cmpt.safebet.controllers;

import java.util.List;
import java.util.Map;

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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class currentBetController {
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private currentBetRepository cbRepo;

    @PostMapping("/placeBet")
    public String placeBet(@RequestParam Map<String, String> newBet, HttpServletResponse response){
        
        
        // later on this will also cross reference userID. We need to tweak the login functionality though.
        // the password is not asked for ease of testing. we can easily ask for username and password here, but
        // there is no point if we're going to change it later.


        // You need to tie newBet to some function in a js file for gamestoday.html. Probably best to use form actions. 
        // see signup for an example.
        // also have to tie newbet so you can replace the dummy values.
        String username = newBet.get("username");
        int betAmount = Integer.valueOf(newBet.get("amount"));
        List<User> userlist = userRepo.findByName(username);

        // THese are dummy values that you have to replace with the values inhereted from GamesToday using newBet!!
        // see buttonclass in gamestoday.html line 53 and 59!! Use gamestoday.js to send info to this controller.
        String betTeam = "A";
        String betMatchup = "B";
        float betOdds = 2.5f;

        //if user is NOT in Users table, return.
        // finish template file noUserFound
        if (userlist.isEmpty()){
            return "currentBets/noUserFound";
        }

        // username exists in database
        else {
            
            cbRepo.save(new currentBet(betAmount, username, betTeam, betMatchup, betOdds));
            response.setStatus(201);

            // do a template for this!!
            return "currentBets/betPlaced";
        }
    }


}
