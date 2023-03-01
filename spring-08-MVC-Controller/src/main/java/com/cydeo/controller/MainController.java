package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home() {      // method will work with which END POINT?
        return "home.html";     // www.amazon.com
    }

    @RequestMapping({"/apple", "/orange","/ozzy"})
    public String home2() {   // ^ can access home page through several end points
        return "home.html";
    }

    @RequestMapping     // Nothing -> Default (usually home page)
    public String home3() {
        return "home.html";
    }
}
