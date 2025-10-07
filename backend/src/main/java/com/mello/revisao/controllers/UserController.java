package com.mello.revisao.controllers;

import com.mello.revisao.domain.usermodel.UserModel;
import com.mello.revisao.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> mostarUsuarios() {
        return userService.mostrarUsuarios();
    }
}