package com.mello.revisao.controllers;

import com.mello.revisao.services.EasterEggService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Esta classe é um teste de conexão

@RestController
public class EasterEggController {
    private final EasterEggService easterEggService;

    public EasterEggController(EasterEggService easterEggService){
        this.easterEggService = easterEggService;
    }

    @GetMapping("/easter-egg")
    public String encontrar(){
           return easterEggService.encontrar();
    }
}

