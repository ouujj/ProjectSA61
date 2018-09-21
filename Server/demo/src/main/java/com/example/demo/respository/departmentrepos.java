package com.example.demo.respository;




import  com.example.demo.entity.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface departmentrepos extends JpaRepository< department, Long> {

}