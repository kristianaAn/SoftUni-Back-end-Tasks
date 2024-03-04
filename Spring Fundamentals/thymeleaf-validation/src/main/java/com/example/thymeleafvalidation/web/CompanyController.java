package com.example.thymeleafvalidation.web;

import com.example.thymeleafvalidation.domain.dtos.CompanyDTO;
import com.example.thymeleafvalidation.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/companies")
public class CompanyController extends BaseController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/add")
    public ModelAndView getCompanyAddPage(@ModelAttribute(name = "companyDTO") CompanyDTO companyDTO) {
        return super.view("company-add");
    }

    @PostMapping("/add")
    public ModelAndView postAddCompanyInfo(@Valid @ModelAttribute(name = "companyDTO") CompanyDTO companyDTO,
                                           BindingResult br, ModelAndView mv) {
        if (br.hasErrors()) {
            mv.setViewName("company-add");
            return mv;
        }

        this.companyService.saveCompany(companyDTO);
        return this.redirect("/companies/all");
    }

    @GetMapping("/all")
    public ModelAndView getAllCompaniesPage(@ModelAttribute(name = "companies") CompanyDTO companies, ModelAndView mv) {
        mv.addObject("companies", this.companyService.findAllCompanies());
        mv.setViewName("company-all");
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView getCompanyDetails(@PathVariable Long id, ModelAndView mv) {

        mv.setViewName("company-details");
        mv.addObject("company", this.companyService.findCompanyById(id));

        return mv;
    }

    @DeleteMapping("/{id}")
    public ModelAndView deleteCompany(@PathVariable("id") Long id) {
        this.companyService.deleteCompanyById(id);
        return this.redirect("/companies/all");
    }
}
