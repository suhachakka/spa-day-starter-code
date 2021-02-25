package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayUserForm(Model model){
        model.addAttribute("title", "Add User");
        return "user/add";
    }
   @PostMapping
   public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(user.getPassword().equalsIgnoreCase(verify)){
            //model.addAttribute("message","Welcome " + user.getUsername());
            // bonus
            UserData.addUser(user);
            model.addAttribute("user",user);
            model.addAttribute("users", UserData.getAll());
            return "user/index";


        }else{
            model.addAttribute("errorMsg","Password didn\'t match");
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email",user.getEmail());
            return  "user/add";
        }
   }
   //bonus

    @GetMapping("details/{userId}")
    public String displayUserDetails(Model model, @PathVariable int userId){
        User user = UserData.getById(userId);
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email",user.getEmail());

        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm");
        String strDate = dateFormat.format(user.getDate());
        model.addAttribute("date",strDate);
        //model.getAttribute("username");
        return "user/details";

    }
}