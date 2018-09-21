package com.example.demo.respository;



import  com.example.demo.entity.job_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface jobrecordrepos extends JpaRepository< job_record, Long> {

}