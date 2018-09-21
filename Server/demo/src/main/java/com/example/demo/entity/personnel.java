package com.example.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
@Entity
@Data
@Table(name="personnel")
public class personnel {
    @Id
    @GeneratedValue

    private  @NonNull Long personid;
    private  @NonNull String name;
    private  @NonNull String phone ;
    private  @NonNull String addrees;
    private  @NonNull String email;
    private  @NonNull String ssid;
    private  @NonNull String birthday;


    protected personnel(){}

    public personnel(String name,String phone,String addrees,String email,String ssid,String birthday,Long personid)
    {
        this.personid=personid;
        this.name=name;
        this.phone=phone;
        this.addrees=addrees;
        this.birthday=birthday;
        this.email=email;
        this.ssid=ssid;
    }
}
