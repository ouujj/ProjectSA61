package com.example.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name="department")

public class department {
    @Id()
    @GeneratedValue

    private  @NonNull Long deploy_id;
    private  @NonNull String deploy_name;
    private  @NonNull int  member;



    protected department(){}

    public department( String deploy_name,int  member){
        this.member=member;
        this.deploy_name=deploy_name;

    }
}


