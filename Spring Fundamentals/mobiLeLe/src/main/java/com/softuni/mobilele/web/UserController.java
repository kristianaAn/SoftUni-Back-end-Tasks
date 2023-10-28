package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtos.LoginUserDTO;
import com.softuni.mobilele.domain.dtos.UserDTO;
import com.softuni.mobilele.domain.entities.User;
import com.softuni.mobilele.services.UserRoleService;
import com.softuni.mobilele.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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

    public UserController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {
        modelAndView.addObject("userRoles", userRoleService.getAllUserRoles());
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }

    @PostMapping("/register")
    public String postRegister(UserDTO userDTO) {
        userService.saveUserRegistrationInfo(userDTO);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return super.view("auth-login");
    }

    @PostMapping("/login")
    public String loggingIn(LoginUserDTO loginUserDTO) {
        Optional<User> optionalUser = userService.findUserByCredentials(loginUserDTO);
        if (optionalUser.isPresent()) {
            return "redirect:/";
        }
        return "redirect:/users/login";
    }
}
