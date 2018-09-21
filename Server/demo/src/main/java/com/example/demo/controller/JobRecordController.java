package com.example.demo.controller;

import com.example.demo.respository.jobrecordrepos;
import com.example.demo.entity.job_record;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController

 class JobRecordController {
    private  jobrecordrepos repository;

    public JobRecordController(jobrecordrepos repository){
        this.repository=repository;
    }

    @GetMapping("/Records")
    public Collection<job_record> job_record() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}
