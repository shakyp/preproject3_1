package ru.shakur.preproject3_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shakur.preproject3_1.model.User;
import ru.shakur.preproject3_1.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String name,
                      @RequestParam int age) {
        var user = new User(name, age);
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id,
                         @RequestParam String name,
                         @RequestParam int age) {
        User user = userService.findById(id);
        user.setName(name);
        user.setAge(age);
        userService.update(user);
        return "redirect:/";
    }

}
