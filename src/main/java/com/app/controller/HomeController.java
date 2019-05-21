package com.app.controller;

import com.app.domain.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService service;


    @GetMapping("/")
    public ModelAndView welcome(){
        ModelAndView model = new ModelAndView();
        List<User> userList = service.findAllUser();
        model.addObject("userLists", userList);
        model.setViewName("wc");
        return model;
    }

    @GetMapping("/userList")
    public ModelAndView userList(){
        ModelAndView model = new ModelAndView("user_list");
        List<User> userList = new ArrayList<>();
        model.addObject("userList", userList);
        return model;
    }

    @GetMapping("/addUserPage")
    public ModelAndView addUserPage(){
        ModelAndView model = new ModelAndView("form");
        model.addObject("User", new User());
        return model;
    }

    @PostMapping("/addUser")
    public ModelAndView addUser(@Valid User user,@RequestParam("file")MultipartFile file){
        try {
            service.saveUser(user,file);
            }
        catch (Exception e){e.printStackTrace();}
        return new ModelAndView("redirect:/");
    }


    }
