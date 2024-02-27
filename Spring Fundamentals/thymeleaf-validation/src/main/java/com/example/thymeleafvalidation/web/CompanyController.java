package com.example.thymeleafvalidation.web;

import com.example.thymeleafvalidation.domain.dtos.CompanyDTO;
import com.example.thymeleafvalidation.repository.CompaniesRepository;
import com.example.thymeleafvalidation.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        mv.setViewName("company-all");
        return mv;
    }

    @GetMapping("/all")
    public ModelAndView getAllCompaniesPage() {
        return super.view("company-all");
    }
}
