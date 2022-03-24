package com.AdvertStatus.model;

import com.AdvertStatus.model.enums.EnrolleeType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@DynamicUpdate
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
