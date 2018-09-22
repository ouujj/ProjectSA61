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
    private  @NonNull String transection;
    private  @NonNull String time;
    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="personid")
    private personnel person  ;

    private Date date = new Date();

    protected job_record(){}

    public job_record(String transection , personnel person,Date date){

        this.time=date.toString();
        this.transection=transection;
        this.person=person;

    }

}
