package com.example.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
@Entity
@Data
@Table(name="JobPosition")
public class Job_position {
    @Id
    @GeneratedValue
    private  @NonNull Long transection;

    private  @NonNull Date date;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="deploy_id")
    private department deploy  ;

    @ManyToOne( )
    @JoinColumn(name="personid")
    private personnel person  ;


    protected Job_position(){}

    public Job_position(Long transection,department deploy ,personnel person){

        this.transection=transection;
        this.date=new Date();
        this.deploy=deploy;
        this.person=person;
    }

}
