package com.example.thymeleafvalidation.web;

import com.example.thymeleafvalidation.domain.dtos.EmployeeDTO;
import com.example.thymeleafvalidation.service.CompanyService;
import com.example.thymeleafvalidation.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeesController extends BaseController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public ModelAndView getAddEmployeePage(@ModelAttribute(name = "employeeDTO") EmployeeDTO employeeDTO) {
        return super.view("employee-add");
    }

    @PostMapping("/add")
    public ModelAndView addEmployee(@Valid @ModelAttribute(name = "employeeDTO") EmployeeDTO employeeDTO,
                                    BindingResult br, ModelAndView mv) {

        if (br.hasErrors()) {
            mv.setViewName("employee-add");
            return mv;
        }

        this.employeeService.saveEmployee(employeeDTO);
        return this.redirect("/employees/all");
    }

    @GetMapping("/all")
    public ModelAndView getAllEmployeesPage(@ModelAttribute(name = "employees") EmployeeDTO employeeDTO, ModelAndView mv) {
        List<EmployeeDTO> employeeDTOS = this.employeeService.findAllEmployees();
        mv.addObject("employees", employeeDTOS);
        mv.setViewName("employee-all");

        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView getEmployeeDetails(@PathVariable Long id, ModelAndView mv) {

        mv.setViewName("employee-details");
        mv.addObject("employee", this.employeeService.findEmployeeById(id));

        return mv;
    }
}
