package com.example.PersonalFinanceTracker.Controller;

import com.example.PersonalFinanceTracker.DTO.UserDTO;
import com.example.PersonalFinanceTracker.Model.User;
import com.example.PersonalFinanceTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    private String index() {
        return "index";
    }

    @GetMapping("/users")
    private String listUsers(Model model) {
        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/new")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users-create";
    }

    @PostMapping("users/new")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable("userId") long userId, Model model) {
        UserDTO user = userService.findById(userId);
        model.addAttribute("user", user);
        return "users-edit";
    }

    @PostMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable("userId") long userId, @ModelAttribute("user") UserDTO user) {
        user.setId(userId);
        userService.updateUser(user);
        return "redirect:/users";
    }
}
