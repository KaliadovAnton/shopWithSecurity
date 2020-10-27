package com.anton.controller;

import com.anton.model.Good;
import com.anton.model.OrderGood;
import com.anton.repository.GoodRepo;
import com.anton.repository.OrderGoodRepo;
import com.anton.repository.OrderRepo;
import com.anton.repository.UserRepo;
import com.anton.service.GoodService;
import com.anton.service.OrderService;
import com.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private GoodService goodService;
    private final ArrayList<Good> tempGoods = new ArrayList<>();
    @Autowired
    private OrderGoodRepo orderGoodRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String addController(@RequestParam(name="currentSelect", required = false) String good,
                                Principal principal,
                                Model model){
        String name = principal.getName();
        if(model.getAttribute("cart") == null){
            model.addAttribute("cart", tempGoods);
        }
        if(good!=null) {
            Good chosenGood = goodService.getProductByName(good.split(" ")[0]);
            tempGoods.add(chosenGood);
            orderGoodRepo.save(new OrderGood(orderService.getOrderByUserName(name), chosenGood));
        }
        model.addAttribute("productList",((ArrayList<Good>) goodService.findAll()));
        model.addAttribute("username", name);
        model.addAttribute("cart", tempGoods);

        return "shop/shop";
    }
}
