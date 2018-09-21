package com.example.demo.controller;

import com.example.demo.respository.Personrepos;
import com.example.demo.entity.personnel;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController

 class personController {
    private Personrepos repository;

    public  personController(Personrepos repository){

        this.repository = repository;
    }

    @GetMapping("/persons")
    public Collection<personnel> personnel() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }


}
