package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.getListUsers();
        model.addAttribute("users", users);
        return "all-users";
    }
    @GetMapping("/createNewUser")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }
    @PostMapping("/") //сохранение
    public String save(@ModelAttribute("user") User theuser){
        userService.saveUser(theuser);
        return "redirect:/users";
    }
    @GetMapping("/editUser/{id}")//редактирование
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "updateUser";
    }
    @PostMapping("/updateUser")
    public String update(@ModelAttribute("update") User user) {
        userService.edit(user);
        return "redirect:/users";
    }

    @DeleteMapping("/deleteUser/{id}") //удаление
    public String deleteById(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
