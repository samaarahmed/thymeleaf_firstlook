package se.lexicon.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class TestController {



    @GetMapping("/hello")
    public String greeting(Model model){
        String message = "Hello Group 40";

        model.addAttribute("message", message);
        return "hello";
    }


}

