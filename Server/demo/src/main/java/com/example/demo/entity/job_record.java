package com.example.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
@Entity
@Data
@Table(name="job_record")
public class job_record {
    @Id
    @GeneratedValue
    private  @NonNull String time;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="personid")
    private personnel person  ;


    protected job_record(){}

    public job_record(String time , personnel person){

        this.time=time;
        this.person=person;

    }

}
