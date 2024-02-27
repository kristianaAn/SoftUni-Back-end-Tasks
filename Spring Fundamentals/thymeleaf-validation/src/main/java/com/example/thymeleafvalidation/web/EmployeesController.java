package com.example.thymeleafvalidation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeesController extends BaseController{

    @GetMapping("/add")
    public ModelAndView getAddEmployeePage() {
        return super.view("employee-add");
    }

    @GetMapping("/all")
    public ModelAndView getAllEmployeesPage() {
        return super.view("employee-all");
    }
}
