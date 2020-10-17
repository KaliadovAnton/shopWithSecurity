package com.anton.controller;

import com.anton.model.Good;
import com.anton.repository.OrderGoodRepo;
import com.anton.service.GoodService;
import com.anton.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private OrderGoodRepo orderGoodRepo;
    private final ArrayList<Good> goodsInTheBasket = new ArrayList<>();
    @Autowired
    private OrderService orderService;

    @PostMapping
    public String showCart(
            @RequestParam("cart") String cart,
            Principal principal,
            Model model){
        String[] basketText = cart.replace("[","").split(" ");
            for(int i = 0; i<basketText.length; i+=2){
                goodsInTheBasket.add(goodService.getProductByName(basketText[i]));
            }
            double total = goodsInTheBasket.stream().map(Good::getPrice).reduce(Double::sum).get();
        orderService.getOrderByUserName(principal.getName()).setTotal(total);
        model.addAttribute("total", total);
        model.addAttribute("basket", goodsInTheBasket);
        model.addAttribute("username",principal.getName());
        model.addAttribute("orderGoods",orderGoodRepo.findAll());
        return "cart/cart";
    }
}
