package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model) {   // <- Model Interface

        // Model Interface method:
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        return "student/welcome";
        //                      ^^ NO .html - Thymeleaf template NOT html
    }
}
