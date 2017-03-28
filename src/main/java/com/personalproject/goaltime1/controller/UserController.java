package com.personalproject.goaltime1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personalproject.goaltime1.domain.User;
import com.personalproject.goaltime1.domain.Users;
import com.personalproject.goaltime1.service.SecurityService;
import com.personalproject.goaltime1.service.UserService;
import com.personalproject.goaltime1.service.UsersService;
import com.personalproject.goaltime1.validator.UserValidator;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UsersService usersService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @ResponseBody
    public Users authenticate(@RequestBody Users req) {
        //    public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password) {
        String authenticateSuccess = "The authentication was successful!";
        //        String totalResponse = authenticateSuccess + username + password;
        //String reqRes = req;

        return req;
    }

    @CrossOrigin
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<Users> getUsers() {
        String getUsersTest = "Testing getUsers was successfully returned";
        System.out.println(getUsersTest);
        return usersService.getUsers();
        // public String signup(Model model) {
        // model.addAttribute("userForm", new User());
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String signupm() {
        String signupTest = "Testing signup was successfully returned";
        return signupTest;
        // public String signup(Model model) {
        // model.addAttribute("userForm", new User());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signup";
        }
        User user = new User("user1","password1");
        userService.saveUser(user);

        securityService.autologin(userForm.getUsername(), userForm.getPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model, String error, String signout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password are invalid.");
        }

        if (signout != null) {
            model.addAttribute("message", "You have been signed out successfully.");
        }

        return "signin";
    }

}
