package com.example.thymeleafvalidation.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
public class HomeController extends BaseController {

    @GetMapping
    public ModelAndView getHomePage() {
        return super.view("index");
    }

}
