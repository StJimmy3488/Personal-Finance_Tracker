package com.example.PersonalFinanceTracker.Controller;

import com.example.PersonalFinanceTracker.DTO.UserDTO;
import com.example.PersonalFinanceTracker.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
