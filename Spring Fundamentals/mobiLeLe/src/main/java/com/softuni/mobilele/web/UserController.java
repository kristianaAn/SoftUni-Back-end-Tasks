package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtos.LoginUserDTO;
import com.softuni.mobilele.domain.dtos.UserDTO;
import com.softuni.mobilele.domain.entities.UserRole;
import com.softuni.mobilele.services.UserRoleService;
import com.softuni.mobilele.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getRegister(@ModelAttribute(name = "userRoles") UserRole userRole, UserDTO userDTO, ModelAndView mv) {
        addUserRolesToView(mv, userRole);
        mv.setViewName("auth-register");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@Valid @ModelAttribute(name = "userDTO") UserDTO userRegData,
                               BindingResult bindingResult, ModelAndView modelAndView, UserRole userRole, LoginUserDTO loginUser) {

        if (bindingResult.hasErrors()) {
            addUserRolesToView(modelAndView, userRole);
            modelAndView.setViewName("auth-register");
            return modelAndView;
        }

        userService.saveUserRegistrationInfo(userRegData);
        modelAndView.setViewName("auth-login");
        return modelAndView;
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

    private void addUserRolesToView(ModelAndView modelAndView, UserRole userRole) {
        modelAndView.addObject("userRoles", userRoleService.getAllUserRoles());
    }

}
