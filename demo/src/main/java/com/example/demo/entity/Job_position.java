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
    private  @NonNull Long pos_id;
    private  @NonNull String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "deploy_name")
    private  department Departments;

    @OneToMany(mappedBy="Position")
    private List<personnel> pos = new ArrayList<>() ;

    protected Job_position(){}

    public Job_position(Long pos_id,String date){

        this.pos_id=pos_id;
        this.date=date;
    }

}
