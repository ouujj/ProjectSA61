package com.example.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
@Entity
@Data
@Table(name="Job_position")
public class Job_position {
    @Id
    @GeneratedValue
    private  @NonNull String date;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="deploy_id")
    private department deploy  ;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="personid")
    private personnel person  ;


    protected Job_position(){}

    public Job_position(String date,department deploy ,personnel person){
        this.date=date;
        this.deploy=deploy;
        this.person=person;
    }

}
