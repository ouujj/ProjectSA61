package com.example.demo.controller;

import com.example.demo.respository.jobpositionrepos;
import com.example.demo.entity.Job_position;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController

class JobPositionController {

    private jobpositionrepos repository;

    public JobPositionController(jobpositionrepos repository){

        this.repository=repository;
    }

    @GetMapping("Positions")
    public Collection<Job_position> Job_position() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

}
