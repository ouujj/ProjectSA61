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
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/persons")

 class personController {
    @Autowired private Personrepos repository;

    public  personController(Personrepos repository){

        this.repository = repository;
    }

    @GetMapping()

    public Collection<personnel> personnel() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping()

    public personnel AddPerson(@RequestBody personnel body){

        return repository.save(body);
    }


    @DeleteMapping("delete/{id}")
    public  boolean deletePerson(@PathVariable  Long id) {
        try {
          repository.deleteById(id);


            return true;
        }catch (Exception e) {
            return false;
        }
    }

       @PutMapping("update")
    public  personnel updatePerson(@RequestBody personnel body) {



        if( repository.findById(body.getPersonid()).get() != null )

        return repository.save(body);

        else return null;
    }



}

