package com.anton.controller;

import com.anton.model.Good;
import com.anton.model.OrderGood;
import com.anton.repository.GoodRepo;
import com.anton.repository.OrderGoodRepo;
import com.anton.repository.OrderRepo;
import com.anton.service.GoodService;
import com.anton.service.OrderService;
import com.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private GoodService goodService;
    private final ArrayList<Good> tempGoods = new ArrayList<>();
    @Autowired
    private GoodRepo goodRepo;
    @Autowired
    private OrderGoodRepo orderGoodRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String addController(@RequestParam(name="currentSelect", required = false) String good,
                                @RequestParam(name="userName", required = false) String name,
                                Model model){
        if(model.getAttribute("cart")==null){
            model.addAttribute("cart", tempGoods);
        }
        if(good!=null) {
            Good chosenGood = goodService.getProductByName(good.split(" ")[0]);
            tempGoods.add(chosenGood);
            orderGoodRepo.save(new OrderGood(orderService.getOrderByUserName(name), chosenGood));

        }

       // model.addAttribute("productList", goodService.getAll());
        model.addAttribute("productList",((ArrayList<Good>) goodRepo.findAll()));
        model.addAttribute("userName", name);
        model.addAttribute("cart", tempGoods);

        return "shop/shop";
    }
}
