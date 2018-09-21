package com.example.demo.controller;


import com.example.demo.respository.departmentrepos;
import com.example.demo.entity.department;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController

class DepartmentController {
    private  departmentrepos repository;

    public DepartmentController(departmentrepos repository){
        this.repository=repository;

    }
    @GetMapping("/Departments")
    public Collection<department> department() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }


}
