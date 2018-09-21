package com.example.demo.respository;


        import  com.example.demo.entity.personnel;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface Personrepos extends JpaRepository< personnel, Long> {

}