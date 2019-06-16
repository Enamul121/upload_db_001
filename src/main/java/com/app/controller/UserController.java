package com.app.controller;

import com.app.domain.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
   private UserService service;

    @GetMapping("/deleteUser/{id}")
    public String delUser(@PathVariable("id") long id){
        service.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUserPage(@PathVariable("id")long id, ModelMap model){

        User user = service.findUserById(id);
        model.addAttribute("User", user);
        return "form";
    }






   }
