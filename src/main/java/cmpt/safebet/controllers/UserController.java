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

import cmpt.safebet.models.User;
import cmpt.safebet.models.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users/view")
    public String getAllUsers(Model model) {
        System.out.println("Getting all users");
        List<User> users = userRepo.findAll();
        model.addAttribute("us", users);
        return "users/showAll";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        
        System.out.println("ADD user");
        String newName = newuser.get("name");
        String newPwd = newuser.get("password");
        String newEmail = newuser.get("userEmail");
        String confirmP = newuser.get("comfirmP");
        // if (newEmail == confirmP) {
            
        // } else {
        //     return "users/userFail";
        // }
        userRepo.save(new User(newName,newPwd,newEmail));
            response.setStatus(201);
            return "users/userAdded";
        
    }
    
}
