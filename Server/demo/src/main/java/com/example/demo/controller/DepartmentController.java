package com.example.demo.controller;

import com.example.demo.respository.departmentrepos;
import com.example.demo.entity.department;

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
@RequestMapping("/Departments")


class DepartmentController {
    private  departmentrepos repository;

    public DepartmentController(departmentrepos repository){
        this.repository=repository;

    }
    @GetMapping()
    public Collection<department> department() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

}
