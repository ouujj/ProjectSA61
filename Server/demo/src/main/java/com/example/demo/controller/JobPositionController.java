package com.example.demo.controller;

import com.example.demo.respository.jobpositionrepos;
import com.example.demo.entity.Job_position;

import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Positions")
class JobPositionController {

    private jobpositionrepos repository;

    public JobPositionController(jobpositionrepos repository){

        this.repository=repository;
    }

    @GetMapping()
    public Collection<Job_position> Job_position() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }












}
