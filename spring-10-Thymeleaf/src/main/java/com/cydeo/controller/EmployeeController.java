package com.cydeo.controller;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")    // localhost:8080/employee/register
    public String register(Model model) {

        List<String> stateList = Arrays.asList("Alaska", "Alabama", "Arkansas", "American Samoa",
                "Arizona", "California", "Colorado", "Connecticut", "District of Columbia",
                "Delaware", "Florida", "Georgia", "Guam", "Hawaii", "Iowa", "Idaho", "Illinois",
                "Indiana", "Kansas", "Kentucky", "Louisiana", "Massachusetts", "Maryland",
                "Maine", "Michigan", "Minnesota", "Missouri", "Mississippi", "Montana",
                "North Carolina", "North Dakota", "Nebraska", "New Hampshire", "New Jersey",
                "New Mexico", "Nevada", "New York", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
                "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
                "Texas", "Utah", "Virginia", "Virgin Islands", "Vermont", "Washington",
                "Wisconsin", "West Virginia", "Wyoming");
        model.addAttribute("stateList", stateList);

        model.addAttribute("employee", new Employee());
        // ^^ adds new Employee object (id="employee") to the Model

        return "employee/employee-register";
    }
}
