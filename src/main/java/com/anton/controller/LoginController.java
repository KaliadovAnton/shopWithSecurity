package com.anton.controller;

import com.anton.model.Good;
import com.anton.model.Order;
import com.anton.model.User;
import com.anton.repository.GoodRepo;
import com.anton.repository.OrderGoodRepo;
import com.anton.repository.OrderRepo;
import com.anton.repository.UserRepo;
import com.anton.service.GoodService;
import com.anton.service.OrderGoodService;
import com.anton.service.OrderService;
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
    private UserService userService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private OrderService orderService;


    @GetMapping("/")
    public String redirectToLogin(){
        goodService.deleteAll();
        goodService.save(new Good("Book", 1));
        goodService.save(new Good("Newspaper", 1.1));
        for(User user: userService.findAll()){
            return "welcome";
        }
        User newUser = new User("user", "user");
        userService.save(newUser);
        orderService.save(new Order(newUser.getId(), 0));
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
        userService.save(newUser);
        orderService.save(new Order(newUser.getId(), 0));
        return "welcome";
    }
    @PostMapping("/login")
    public RedirectView registerUser(@RequestParam String username, @RequestParam String password, Model model){
        User user = new User(username, password);
        userService.save(user);
        orderService.save(new Order(user.getId(), 0));
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
