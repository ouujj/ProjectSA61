package com.example.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
import java.util.Date;


@Entity
@Data
@Table(name="job_record")

public class job_record {

    @Id
    @GeneratedValue
    private  @NonNull Long transection;
    private  @NonNull Date time;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="personid")
    private personnel person  ;



    protected job_record(){}

    public job_record(Long transection , personnel person){

        this.time= new Date();
        this.transection=transection;
        this.person=person;

    }

}
