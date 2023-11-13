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

    @GetMapping("/currentBets/view")
    public String getAllCurrentBets(Model model) {
        System.out.println("Getting all current bets");
        List<currentBet> currentBets = cbRepo.findAll();
        model.addAttribute("us", currentBets);
        return "currentBets/displayCurrBets";
    }

    @PostMapping("/currentBets/placeBet")
    public String placeBet(@RequestParam Map<String, String> newBet, HttpServletResponse response, Model model, HttpServletRequest request, HttpSession session){
        
        
        // later on this will also cross reference userID. We need to tweak the login functionality though.
        // the password is not asked for ease of testing. we can easily ask for username and password here, but
        // there is no point if we're going to change it later.

        System.out.println("ADD currentBet");

        // You need to tie newBet to some function in a js file for gamestoday.html. Probably best to use form actions. 
        // see signup for an example.
        // also have to tie newbet so you can replace the dummy values.
        
        User userN = (User) session.getAttribute("session_user");
        String username =  userN.getName(); 
        int betAmount = Integer.parseInt(newBet.get("betAmount"));

        System.out.println(username + " " + betAmount);
        List<User> userlist = userRepo.findByName(username);
        


        if( userlist.isEmpty()) {
            return "/currentBets/noUserFound";
        }
        // THese are dummy values that you have to replace with the values inhereted from GamesToday using newBet!!
        // see buttonclass in gamestoday.html line 53 and 59!! Use gamestoday.js to send info to this controller.
        String betTeam = newBet.get("data-team");
        String betMatchup = newBet.get("data-against");
        String betO = newBet.get("data-odds");
        float betOdds = Float.valueOf((betO));
        System.out.println(userlist);
        

        User user = userlist.remove(0);
        //if balance is less than betamount, we cant make that bet (no negative balance allowed!!)
        if(user.getBalance() < betAmount)
        {
            return "/currentBets/insufficient";
        }
        
        
        // username exists in database
        else {

            
            int bal = user.getBalance();
            user.setBalance(bal - betAmount);
            cbRepo.save(new currentBet(betAmount, username, betTeam, betMatchup, betOdds));
            response.setStatus(201);

            // do a template for this!!
            return "currentBets/betPlaced";
        }
    }


}
