package com.EmlakBurada.model;

import com.EmlakBurada.model.enums.EnrolleeType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Enrollee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int enrolleeId;
    @Enumerated(EnumType.STRING)
    EnrolleeType enrolleeType;
    private String firstName;
    private String lastName;
    private String email;
    private  String password;
    private String phoneNumber;
    @ManyToMany
    Set<Advert>favoriteAdverts=new HashSet<>();



}
