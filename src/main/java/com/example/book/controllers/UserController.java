package com.example.book.controllers;

import com.example.book.model.User;
import com.example.book.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
@Slf4j
@Controller
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/users"})
    public String getUsers(Model model) {

        model.addAttribute("users", userService.getAll());
        return "users/index";

    }
    @RequestMapping(value="/user/delete")
    public String deleteUser(@RequestParam Long id , Model model) {

        userService.delete(id);
        return "redirect:/users";

    }

    @GetMapping({"/addNewUser"})
    public String newUser(Model model) {
        //model.addAttribute("userTypes", new LinkedList<UserType>(Arrays.asList(UserType.values())));
        model.addAttribute("user", new User());

        return "users/add";
    }

    @PostMapping("/save-user")
    public String saveOrUpdate(@ModelAttribute User user){
        userService.save(user);

        return "redirect:/users";
    }
}
