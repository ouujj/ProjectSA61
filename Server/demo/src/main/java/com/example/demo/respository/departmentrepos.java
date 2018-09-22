package com.example.demo.respository;

import org.springframework.web.bind.annotation.CrossOrigin;
import  com.example.demo.entity.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public
interface departmentrepos extends JpaRepository< department, Long> {

}