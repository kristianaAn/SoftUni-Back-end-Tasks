package com.example.thymeleafvalidation.web;

import com.example.thymeleafvalidation.domain.dtos.CompanyDTO;
import com.example.thymeleafvalidation.domain.dtos.EmployeeDTO;
import com.example.thymeleafvalidation.domain.entities.Company;
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
    private final CompanyService companyService;

    @Autowired
    public EmployeesController(EmployeeService employeeService, CompanyService companyService1) {
        this.employeeService = employeeService;
        this.companyService = companyService1;
    }

    @GetMapping("/add")
    public ModelAndView getAddEmployeePage(@ModelAttribute(name = "companies") Company company, EmployeeDTO employeeDTO,
                                           ModelAndView mv) {
        mv.addObject("companies", this.companyService.findAllCompanies());
        mv.setViewName("employee-add");

        return mv;
    }

    @PatchMapping("/add")
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
    public ModelAndView getEmployeeDetails(@PathVariable Long id, CompanyDTO companyDTO, ModelAndView mv) {

        mv.addObject("employee", this.employeeService.findEmployeeById(id));
        mv.setViewName("employee-details");

        return mv;
    }

    @DeleteMapping("/{id}")
    public ModelAndView deleteEmployee(@PathVariable Long id) {
        this.employeeService.deleteEmployeeById(id);

        return this.redirect("/employees/all");
    }
}
