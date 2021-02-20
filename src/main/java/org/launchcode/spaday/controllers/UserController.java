package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayUserForm(Model model){
        model.addAttribute("title", "Add User");
        return "user/add";
    }
   @PostMapping
   public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(user.getPassword().equalsIgnoreCase(verify)){
            model.addAttribute("message","Welcome " + user.getUsername());
        }else{
            model.addAttribute("errorMsg","Password didn\'t match");
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email",user.getEmail());
            return  "user/add";
        }
    return "user/index";
   }

}
