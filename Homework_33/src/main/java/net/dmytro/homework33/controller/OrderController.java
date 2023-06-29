package net.dmytro.homework33.controller;

import lombok.RequiredArgsConstructor;
import net.dmytro.homework33.entity.Order;
import net.dmytro.homework33.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
   private  OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping({"/{id}"})
    public String getOrderById(@RequestParam UUID id, Model model){
        model.addAttribute("order",orderRepository.getOrderById(id));

        return "order/orderById";
    }
    @GetMapping
    public String getAllOrders(Model model){
        model.addAttribute("orders", orderRepository.getAllOrders());
        return "order/allOrders";
    }
    @GetMapping("/create")
    public String createOrder(@ModelAttribute("order") Order order){
        return "order/addOrder";
    }
    @PostMapping
    public String addOrder(@ModelAttribute("order")Order order){
        orderRepository.addToOrder(order);
        return "redirect:/orders";
    }

}
