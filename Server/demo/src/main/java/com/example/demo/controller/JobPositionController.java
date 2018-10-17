package com.example.demo.controller;

import com.example.demo.respository.*;
import com.example.demo.entity.*;

import java.util.Collection;
import java.util.Optional;
import java.util.Map;
import javax.validation.Valid;
import java.util.Date;

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
@RequestMapping("/Positions")
class JobPositionController {

    @Autowired private jobpositionrepos repository;
    @Autowired private departmentrepos departmentRepository;
    @Autowired private Personrepos personRepository;



    @GetMapping()
    public Collection<Job_position> Job_position() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping()
    public Job_position  position(Job_position newJob,@RequestBody Map<String,Object> body){

        Optional<department> depart = departmentRepository.findById(Long.valueOf(body.get("deploy").toString()));
        Optional<personnel> person = personRepository.findById(Long.valueOf(body.get("person").toString()));

        newJob.setDeploy(depart.get());
        newJob.setPerson(person.get());
        newJob.setDate(new Date());
        return repository.save(newJob);
    }










}
