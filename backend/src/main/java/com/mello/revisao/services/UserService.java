package com.mello.revisao.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String exibir() {
        System.out.println("O usuário está conectando no controlador de Usuários!");
        return "Usuário";
    }
}
