package com.AdvertPocket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


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



}
