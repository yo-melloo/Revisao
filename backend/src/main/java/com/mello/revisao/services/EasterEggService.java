package com.mello.revisao.services;

import org.springframework.stereotype.Service;

// Esta classe é um teste de conexão

@Service
public class EasterEggService {
    public String encontrar(){
        System.out.println("O usuário encontrou o EasterEgg");
        return "Você me encontrou!";
    }
}
