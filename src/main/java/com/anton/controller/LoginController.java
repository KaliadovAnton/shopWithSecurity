package com.anton.controller;

import com.anton.model.Good;
import com.anton.model.Order;
import com.anton.model.User;
import com.anton.repository.GoodRepo;
import com.anton.repository.OrderGoodRepo;
import com.anton.repository.OrderRepo;
import com.anton.repository.UserRepo;
import com.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GoodRepo goodRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderGoodRepo orderGoodRepo;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String redirectToLogin(){
        goodRepo.deleteAll();
        goodRepo.save(new Good("Book", 1));
        goodRepo.save(new Good("Newspaper", 1.1));
        for(User user: userRepo.findAll()){
            return "welcome";
        }
        User newUser = new User("user", "user");
        userRepo.save(newUser);
        orderRepo.save(new Order(newUser.getId(), 0));
        return "welcome";
    }
    @GetMapping("/new")
    public String newUser(){
        return "registration";
    }

    @PostMapping("/congratulations")
    public String registerNewUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model){
        User newUser = new User(username, password);
        userRepo.save(newUser);
        orderRepo.save(new Order(newUser.getId(), 0));
        return "welcome";
    }
    @PostMapping("/login")
    public RedirectView registerUser(@RequestParam String username, @RequestParam String password, Model model){
        User user = new User(username, password);
        userRepo.save(user);
        orderRepo.save(new Order(user.getId(), 0));
        model.addAttribute("username", username);
        return new RedirectView("/shop");
    }

    @GetMapping("/login")
    //Can return String, Model, View, ModelAndView
    public ModelAndView getLoginPage(ModelAndView model) {
        //Predefined username
        User user = new User("username", "password");
        model.addObject("user", user);
        model.setViewName("welcome");
        return model;
    }

}
