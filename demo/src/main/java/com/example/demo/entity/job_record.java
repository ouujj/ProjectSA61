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
    private  @NonNull Long id;
    private  @NonNull String time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="personid")
    private  job_record Records;

    protected job_record(){}

    public job_record(String time){

        this.time=time;


    }

}
