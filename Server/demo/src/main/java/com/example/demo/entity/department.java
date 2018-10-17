package com.example.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name="department")

public class department {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  @NonNull Long deploy_id;
    private  @NonNull String deploy_name;

    protected department(){}

    public department( String deploy_name){
        this.deploy_name=deploy_name;
    }
}


