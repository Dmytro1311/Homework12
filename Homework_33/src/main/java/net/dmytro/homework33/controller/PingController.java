package net.dmytro.homework33.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PingController {

    @GetMapping("/ping")
    public String ping (){
        return "ping/ping";
    }
}
