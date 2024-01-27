package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtos.LoginUserDTO;
import com.softuni.mobilele.domain.dtos.UserDTO;
import com.softuni.mobilele.services.UserRoleService;
import com.softuni.mobilele.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private UserRoleService userRoleService;
    private UserService userService;

    @Autowired
    public UserController(UserRoleService userRoleService, UserService userService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView, UserDTO userDTO) {
        modelAndView.addObject("userRoles", userRoleService.getAllUserRoles());
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute UserDTO userDTO) {

        userService.saveUserRegistrationInfo(userDTO);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(LoginUserDTO loginUser) {
        return super.view("auth-login");
    }

    @PostMapping("/login")
    public String loggingIn(@Valid @ModelAttribute LoginUserDTO loginUserDTO) {

        if (this.userService.loginUser(loginUserDTO).getId() > 0) {
            return "redirect:/";
        }
        return "redirect:/users/login";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logoutUser() {
        this.userService.logout();

        return "redirect:/";
    }
}
