package com.example.demostracao.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String HelloWord(String name){
        return "Hello Word " + name;
    }

}
