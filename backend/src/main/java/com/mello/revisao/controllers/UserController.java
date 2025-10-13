package com.mello.revisao.controllers;

import com.mello.revisao.domain.usermodel.UserModel;
import com.mello.revisao.dtos.UserProfileDTO;
import com.mello.revisao.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> mostrarUsuarioPorID(@PathVariable Long id) {
        UserModel user = userService.buscarPorID(id);
        UserProfileDTO dto = new UserProfileDTO(user);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileDTO> carregarUsuario(@AuthenticationPrincipal UserDetails userDetails) {
        UserModel user = userService.buscarPorUsername(userDetails.getUsername());
        UserProfileDTO dto = new UserProfileDTO(user);
        return ResponseEntity.ok(dto);
    }

}