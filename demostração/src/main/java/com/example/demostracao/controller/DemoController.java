package com.example.demostracao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demostracao.domais.User;
import com.example.demostracao.service.DemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/helloworld")

public class DemoController {
    @Autowired
    private DemoService demoService;

    /*public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }*/

    @GetMapping
    public String HelloWord(){
        return demoService.HelloWord("João");
    }

    @PostMapping("")
    public String HelloWordPost(@RequestBody User body) {
        return "Hellor Word " + body.getName();
    }
    
    @PostMapping("/autenticar")
    public ResponseEntity<String> autenticar(@RequestBody User user) {
        if ("admin".equals(user.getName()) && "test@test".equals(user.getEmail())) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha no login: credenciais inválidas.");
        }
        
    }

    
}
