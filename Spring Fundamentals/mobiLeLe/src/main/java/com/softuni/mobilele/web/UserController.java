package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtos.LoginUserDTO;
import com.softuni.mobilele.domain.dtos.UserDTO;
import com.softuni.mobilele.services.UserRoleService;
import com.softuni.mobilele.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public UserController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {
        modelAndView.addObject("userRoles", userRoleService.getAllUserRoles());
        return super.view("auth-register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView postRegister(UserDTO userDTO) {
        userService.saveUserRegistrationInfo(userDTO);
        return super.view("auth-login");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(ModelAndView mv) {
        return super.view("auth-login");
    }

    @PostMapping("/login")
    public ModelAndView loggingIn(LoginUserDTO loginUserDTO) {
        return redirect("/index");
    }
}
