package com.mello.revisao.controllers;

import com.mello.revisao.domain.usermodel.UserModel;
import com.mello.revisao.dtos.AuthenticationDTO;
import com.mello.revisao.dtos.LoginResponseDTO;
import com.mello.revisao.dtos.RegisterDTO;
import com.mello.revisao.repository.UserRepository;
import com.mello.revisao.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AutenticationController {

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var user = (UserModel) auth.getPrincipal();
        System.out.println("Role do USUÁRIO AUTENTICADO: " + user.getRole());

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        System.out.println("=== Processo de Registro ===");

        // valida se email e nome e login informados não são nulos ou vazios
        if (data.login() == null || data.login().isBlank() || data.name() == null || data.email() == null
                || data.name().isBlank() || data.email().isBlank()) {
            return ResponseEntity.badRequest().body("Nome e email e login são obrigatórios!");
        }

        System.out.println("DADOS RECEBIDOS: " + data);
        if (this.userRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.login(), encryptedPassword, data.role(), data.name(), data.email());
        System.out.println("Role do NOVO USUÁRIO: " + newUser.getRole());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

}
