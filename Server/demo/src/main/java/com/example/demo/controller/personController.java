package com.example.demo.controller;

import com.example.demo.respository.Personrepos;
import com.example.demo.entity.personnel;

import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/persons")
 class personController {
    private Personrepos repository;

    public  personController(Personrepos repository){

        this.repository = repository;
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<personnel> personnel() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping()
    public personnel AddPerson(@Valid @RequestBody personnel body){
        return   repository.save(body);
    }

    @DeleteMapping("/{id}")
    public  boolean deletePerson(@PathVariable("personid") Long id) {
        try {
          repository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/{id}")
    public  personnel updatePerson(@PathVariable("personid") Long id, @Valid @RequestBody personnel body) {
        body.setPersonid(id);
       return repository.save(body);
    }






}